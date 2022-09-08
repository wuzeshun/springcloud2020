package com.wzs.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "SERVICE-HYSTRIX-PROVIDER",fallback = PaymentFallback.class)
public interface PaymentProviderService {
    @GetMapping("/get/payment/ok/{id}")
    String getPayment_ok(@PathVariable("id")long id);

    @GetMapping("/get/payment/timeout/{id}")
    String getPayment_timeout(@PathVariable("id")long id);
}
