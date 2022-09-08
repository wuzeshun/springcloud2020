package com.wzs.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wzs.springcloud.service.PaymentProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "Global_timeoutHandler")
public class ConsumerHystrixCotroller {



    @Autowired
    @Qualifier("com.wzs.springcloud.service.PaymentProviderService")
    private PaymentProviderService pService;

    @GetMapping("/consumer/get/payment/ok/{id}")
//    @HystrixCommand
    public String getPayment_ok(@PathVariable("id") long id){
        log.info("in the method hystrix ok");
        return pService.getPayment_ok(id);
    }
    @GetMapping("/consumer/get/payment/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "timeoutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
//    })
    public String getPayment_timeout(@PathVariable("id") long id) {
            return pService.getPayment_timeout(id);
    }

    public String timeoutHandler(@PathVariable("id") long id){
        return "服务器繁忙稍后再试！(。・＿・。)ﾉI’m sorry~！请求id："+id;
    }

    /**
     * 全局fallback方法
     * @return
     */
//    public String Global_timeoutHandler(){
//        return "服务器繁忙稍后再试！(。・＿・。)ﾉI’m sorry~!";
//    }
}
