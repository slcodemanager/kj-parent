package com.kj.consume.service;

import com.github.pagehelper.PageInfo;
import com.kj.consume.entity.KProduct;
import com.kj.consume.entity.KProductAlbum;
import com.kj.consume.entity.KProductSpec;
import com.kj.consume.vo.ProductInfoBo;
import com.kj.consume.vo.ProductSearchParams;

import java.util.List;

/**
 * @author quan
 * @date 2021-01-18 12:40
 */

public interface ProductService {
    PageInfo<KProduct> getProductPageList(ProductSearchParams params);

    ProductInfoBo getProductInfoById(Long id);

    KProduct getProductById(Long id);

    KProductSpec getProductSpecById(Long specId);

    List<KProductSpec> getProductSpecByProductId(Long productId);

    List<KProductAlbum> getProductAlbumByProduct(Long productId);

    void updProductSpecStock(Long id, Integer amount);

    void updProductStock(Long id, Integer amount);
}
