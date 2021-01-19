package com.kj.consume.mapper;

import com.kj.consume.base.BaseMapper;
import com.kj.consume.entity.KProduct;
import com.kj.consume.vo.ProductSearchParams;

import java.util.List;

public interface KProductMapper extends BaseMapper<KProduct> {
    List<KProduct> selectGoodList(ProductSearchParams params);
}