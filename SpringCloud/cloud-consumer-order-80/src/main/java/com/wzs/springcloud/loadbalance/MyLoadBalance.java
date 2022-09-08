package com.wzs.springcloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface MyLoadBalance {

    ServiceInstance getInstance(List<ServiceInstance> serviceInstances);

}
