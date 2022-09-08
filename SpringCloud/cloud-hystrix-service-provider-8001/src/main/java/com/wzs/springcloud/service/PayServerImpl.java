package com.wzs.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.concurrent.TimeUnit;

@Component
public class PayServerImpl {

    public String getPayment_ok(long id){


        return "当前线程："+Thread.currentThread().getName()+"查询id为："+id+"查询状态为：ok!";
    }

    /**
     * 配置服务降级，并设置服务处理时限，3秒内为正常，超过3秒就会启动服务降级策略
     * @param id
     * @return  状态info
     */
    @HystrixCommand(fallbackMethod = "timeoutHandler",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String getPayment_timeout(long id){
        int time= 5;
        try {

           TimeUnit.SECONDS.sleep(time);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "当前线程："+Thread.currentThread().getName()+"查询id为："+id+"查询状态为：timeoute!"+"损耗时间为："+time;
    }

    /**
     * 备选方法，服务降级开启后调用的方法，也就是说当正常的服务不可用或者超时后就会调用该方法，快速的做出响应和反馈
     * 而不是让出错的服务一直占用资源等待，将服务耗死
     * @param id
     * @return
     */
    public String timeoutHandler(long id){
        return "当前系统业务繁忙请稍后再试！Thanks♪(･ω･)ﾉ";
    }

    /**
     * 服务熔断
     * id是否合法
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "Error",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),// 失败率达到多少后跳闸
    })
    public String isTrueId(long id){
        if(id>0){
            return "this id is true! id:"+id+"uuid:"+ IdUtil.simpleUUID();
        }
        else {
            throw new RuntimeException("id is false,because id's value small of 0");
        }

    }
    public String Error(long id){
        return "service error ,please try again after 10s！id:"+id;
    }


}
