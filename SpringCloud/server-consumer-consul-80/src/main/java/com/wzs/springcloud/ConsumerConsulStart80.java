package com.wzs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerConsulStart80 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerConsulStart80.class,args);
    }
}
