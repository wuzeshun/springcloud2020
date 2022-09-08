package com.wzs.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallback implements PaymentProviderService{
    @Override
    public String getPayment_ok(long id) {
        return "当前getPayment_ok服务繁忙，请稍后重试！(。・＿・。)ﾉI’m sorry~！";
    }

    @Override
    public String getPayment_timeout(long id) {
        return "当前getPayment_timeout服务繁忙，请稍后重试！(。・＿・。)ﾉI’m sorry~！";
    }
}
