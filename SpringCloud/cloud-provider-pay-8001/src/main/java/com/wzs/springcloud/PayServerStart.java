package com.wzs.springcloud;

import com.wzs.springcloud.pojo.PayMent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PayServerStart {
    public static void main(String[] args) {
        SpringApplication.run(PayServerStart.class,args);
    }
}
