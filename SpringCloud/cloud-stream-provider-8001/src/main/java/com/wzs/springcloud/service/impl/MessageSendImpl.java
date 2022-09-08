package com.wzs.springcloud.service.impl;

import com.wzs.springcloud.service.MessageSend;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
public class MessageSendImpl implements MessageSend {

    /**
     * 消息的发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        // 创建并发送消息
        this.output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("生产者生产的消息是serial: " + serial);

        return serial;
    }
}
