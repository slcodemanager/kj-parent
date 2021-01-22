package com.kj.consume.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kj.common.asser.A;
import com.kj.common.exp.E;
import com.kj.consume.entity.KProduct;
import com.kj.consume.entity.KProductAlbum;
import com.kj.consume.entity.KProductSpec;
import com.kj.consume.mapper.KProductAlbumMapper;
import com.kj.consume.mapper.KProductMapper;
import com.kj.consume.mapper.KProductSpecMapper;
import com.kj.consume.service.ProductService;
import com.kj.consume.vo.ProductInfoBo;
import com.kj.consume.vo.ProductSearchParams;
import com.kj.consume.vo.SpecVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author quan
 * @date 2021-01-18 12:40
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private KProductMapper productMapper;
    @Resource
    private KProductSpecMapper specMapper;
    @Resource
    private KProductAlbumMapper albumMapper;

    @Override
    public PageInfo<KProduct> getProductPageList(ProductSearchParams params) {
        PageHelper.startPage(params.getPage(), params.getPerPage());
        return new PageInfo<KProduct>(productMapper.selectGoodList(params));
    }

    @Override
    public KProduct getProductById(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    public List<KProductSpec> getProductSpecByProductId(Long productId) {
        KProductSpec spec = new KProductSpec();
        spec.setProductId(productId);
        return specMapper.select(spec);
    }

    public List<KProductAlbum> getProductAlbumByProduct(Long productId) {
        Example example = new Example(KProductAlbum.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId", productId);
        example.setOrderByClause(" order_num desc,id asc ");
        return albumMapper.selectByExample(example);
    }

    @Override
    public ProductInfoBo getProductInfoById(Long id) {
        KProduct result = getProductById(id);
        List<KProductSpec> specs = getProductSpecByProductId(id);
        List<SpecVo> skus = specs.stream().filter(m -> !m.getParent().equals(0L)).map(m -> {
            List<KProductSpec> child = specs.stream().distinct().filter(c -> c.getId().equals(m.getParent())).collect(Collectors.toList());
            SpecVo specVo = new SpecVo();
            specVo.setTitle(m.getTitle());
            specVo.setAttr(child);
            return specVo;
        }).collect(Collectors.toList());

        List<KProductAlbum> albums = getProductAlbumByProduct(id);
        List<String> shareImg = albums.stream().filter(m -> "1".equals(m.getType().toString())).distinct().map(m -> m.getUrl()).collect(Collectors.toList());
        List<String> detailImg = albums.stream().filter(m -> "2".equals(m.getType().toString())).distinct().map(m -> m.getUrl()).collect(Collectors.toList());

        ProductInfoBo ret = new ProductInfoBo();
        BeanUtils.copyProperties(result, ret);
        ret.setSpecs(skus);
        ret.setDetailImg(detailImg);
        ret.setShareImg(shareImg);
        return ret;
    }

    @Override
    public KProductSpec getProductSpecById(Long specId) {
        return specMapper.selectByPrimaryKey(specId);
    }

    @Transactional
    @Override
    public void updProductSpecStock(Long id, Integer amount) {
        KProductSpec spec = specMapper.selectByPrimaryKey(id);
        A.notNull(spec, "规格信息不能为空");
        Integer stock = spec.getStock() - amount;
        A.of(stock > -1, "商品库存不足");
        KProductSpec record = new KProductSpec();
        record.setId(id);
        record.setStock(stock);
        if (specMapper.updateByPrimaryKeySelective(record) != 1) {
            throw new E("修改商品库存失败");
        }
    }

    @Transactional
    @Override
    public void updProductStock(Long id, Integer amount) {
        KProduct product = productMapper.selectByPrimaryKey(id);
        A.notNull(product, "商品信息不能为空");
        Long number = product.getNumber();
        Long stock = number - amount;
        A.of(stock.intValue() > -1, "商品库存不足");
        KProduct record = new KProduct();
        record.setId(id);
        record.setNumber(stock);
        if (productMapper.updateByPrimaryKeySelective(record) != 1) {
            throw new E("修改商品库存失败");
        }
    }

}

