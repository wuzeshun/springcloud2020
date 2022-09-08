package com.wzs.springcloud.controller;


import com.wzs.springcloud.loadbalance.MyLB;
import com.wzs.springcloud.pojo.CommentResult;
import com.wzs.springcloud.pojo.PayMent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;


@RestController
@Slf4j
public class OrderConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MyLB myLB;

    @Autowired
    private DiscoveryClient discoveryClient;

//    private static final String HTTP_URL="http://localhost:8001/";
    //不在关注端口号，通过服务名称来回去服务通信地址
    private static final String HTTP_URL="http://PAYMENT-SERVER-PROVIDER";

    @GetMapping("/consumer/get/{id}")
    public CommentResult getById(@PathVariable("id") long id){
        log.info("into consumer selectOne");
        return restTemplate.getForObject(HTTP_URL+"/get/"+id, CommentResult.class);
    }

    @GetMapping("/consumer/get/list")
    public CommentResult getAll(){
        log.info("into consumer selectAll");
        return restTemplate.getForObject(HTTP_URL+"/get/list", CommentResult.class);
    }
    @GetMapping("/consumer/create")
    public CommentResult createPayment(){
        log.info("into consumer create");
        return restTemplate.getForObject(HTTP_URL+"create", CommentResult.class);
    }

    @GetMapping("/consumer/port")
    public String getPort(){
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("PAYMENT-SERVER-PROVIDER");
        ServiceInstance ServiceInstance = myLB.getInstance(serviceInstanceList);
        if(ServiceInstance==null || serviceInstanceList.size() <=0){
            return null;
        }
        URI uri = ServiceInstance.getUri();

        return restTemplate.getForObject(uri+"/get/port",String.class);
    }
}
