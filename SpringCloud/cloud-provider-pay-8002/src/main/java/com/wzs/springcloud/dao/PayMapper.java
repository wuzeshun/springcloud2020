package com.wzs.springcloud.dao;

import com.wzs.springcloud.pojo.PayMent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PayMapper {
    public PayMent queryById(@Param("id") long id);

    public List<PayMent> queryAll();

    public int create(PayMent payment);
}
