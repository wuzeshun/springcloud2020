package com.wzs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenFeignStarter {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignStarter.class,args);
    }
}
