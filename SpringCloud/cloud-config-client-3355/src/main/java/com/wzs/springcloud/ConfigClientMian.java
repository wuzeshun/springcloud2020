package com.wzs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMian {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMian.class,args);
    }
}
