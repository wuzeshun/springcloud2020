package com.wzs.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


@Component
@EnableBinding(Sink.class)
public class MessageConsumerController {
    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void ConsumerMessage(Message<String> message){
        System.out.println( "正在消费消息的端口port:"+port+"\t"+"消费的消息是:"+message.getPayload());
    }
}
