package com.we.dao;

import java.util.Map;

import com.we.common.mybatis.MyBatisMapper;

@MyBatisMapper
public interface TrainMapper {
	Integer selectCount(Map<String, Object> parmap);
}
