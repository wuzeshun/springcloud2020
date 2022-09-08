package com.wzs.springcloud.service;

import com.wzs.springcloud.pojo.CommentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "PAYMENT-SERVER-PROVIDER")
public interface ProviderService {
    @GetMapping("/get/{id}")
    CommentResult getPayMent(@PathVariable("id")long id);
    @GetMapping("/timeout/port")
    public String getPort();
}
