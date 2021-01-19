package com.kj.consume.controller.product;

import com.github.pagehelper.PageInfo;
import com.kj.common.result.R;
import com.kj.consume.entity.KProduct;
import com.kj.consume.service.ProductService;
import com.kj.consume.vo.PageVo;
import com.kj.consume.vo.ProductInfoBo;
import com.kj.consume.vo.ProductSearchParams;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author quan
 * @date 2021-01-18 11:49
 */

@Api("商品")
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public R pageList(ProductSearchParams params) {
        PageInfo<KProduct> result = productService.getProductPageList(params);
        PageVo pageVo = new PageVo(result.getTotal(), result.getPageSize(), result.getPageNum(), result.getNavigateLastPage(), result.getList());
        return R.ok(pageVo);
    }

    @GetMapping("/{id}")
    public  R productInfo(@PathVariable("id") Long id){
        ProductInfoBo result =  productService.getProductInfoById(id);
        return  R.ok(result);
    }
}
