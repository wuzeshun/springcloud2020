package com.wzs.springcloud.controller;

import com.wzs.springcloud.service.PayServerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PayController {
    @Autowired
    private PayServerImpl payserver;


    @GetMapping("/get/payment/ok/{id}")
    public String getPayment_ok(@PathVariable("id") long id){

      return payserver.getPayment_ok(id);
    }

    @GetMapping("/get/payment/timeout/{id}")
    public String getPayment_timeout(@PathVariable("id")long id){

        return payserver.getPayment_timeout(id);
    }

    @GetMapping("/get/payment/istureId/{id}")
    public String isTureId(@PathVariable("id")long id){

        return payserver.isTrueId(id);
    }
}
