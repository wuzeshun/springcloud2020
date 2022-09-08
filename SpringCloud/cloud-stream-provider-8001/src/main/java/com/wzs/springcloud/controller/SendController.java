package com.wzs.springcloud.controller;


import com.wzs.springcloud.service.MessageSend;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class SendController {
    @Resource
    private MessageSend messageSend;
    @GetMapping("/send")
    public String sendMessage(){
        return messageSend.send();
    }
}
