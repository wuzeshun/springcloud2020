package com.wzs.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CloudConsul {

    @Value("${server.port}")
    private int server_port;
    @GetMapping("/consul/server")
    public String payMentConsul(){
        return "consul server provider port"+server_port+ UUID.randomUUID().toString();
    }

}
