package com.wzs.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerConsulController {

    @Autowired
    private RestTemplate template;

    private static  final  String GET_URL="http://cloud-server-provider/";

    @GetMapping("/consumer/consul")
    public String paymentConsumer(){
        return template.getForObject(GET_URL+"/consul/server",String.class);
    }
}
