package com.wzs.springcloud.controller;

import com.wzs.springcloud.service.ProviderService;
import com.wzs.springcloud.pojo.CommentResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FeignCotroller {
    @Autowired
    private ProviderService providerService;

    @GetMapping("/feign/get/{id}")
    public CommentResult getPaymentInfo(@PathVariable("id") long id){
        System.out.println("进入了这个方法");
        return providerService.getPayMent(id);
    }

    @GetMapping("/timeout/port")
    String getPort() {
        return providerService.getPort();
    }
}
