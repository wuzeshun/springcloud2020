package com.wzs.springcloud.server;

import com.wzs.springcloud.pojo.PayMent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayServer {
    public PayMent queryById(long id);

    public List<PayMent> queryAll();

    public int create(PayMent payment);
}
