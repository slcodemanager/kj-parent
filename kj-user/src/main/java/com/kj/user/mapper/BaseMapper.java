package com.kj.user.mapper;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.base.insert.InsertMapper;

/**
 * @author quan
 * @date 2020-11-25 15:21
 */

public interface BaseMapper<T> extends Mapper<T>,IdsMapper<T>,InsertMapper<T> {
}
