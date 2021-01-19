package com.kj.consume.service;

import com.github.pagehelper.PageInfo;
import com.kj.consume.entity.KProduct;
import com.kj.consume.vo.ProductInfoBo;
import com.kj.consume.vo.ProductSearchParams;

/**
 * @author quan
 * @date 2021-01-18 12:40
 */

public interface ProductService {
    PageInfo<KProduct> getProductPageList(ProductSearchParams params);

    ProductInfoBo getProductInfoById(Long id);
}
