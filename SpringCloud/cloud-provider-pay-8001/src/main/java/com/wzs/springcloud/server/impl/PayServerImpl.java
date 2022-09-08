package com.wzs.springcloud.server.impl;

import com.wzs.springcloud.dao.PayMapper;
import com.wzs.springcloud.pojo.PayMent;
import com.wzs.springcloud.server.PayServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PayServerImpl implements PayServer {
    @Autowired
    private PayMapper payMapper;
    @Override
    public PayMent queryById(long id) {
        return payMapper.queryById(id);
    }

    @Override
    public List<PayMent> queryAll() {
        return payMapper.queryAll();
    }

    @Override
    public int create(PayMent payment) {
        return payMapper.create(payment);
    }
}
