package com.wzs.springcloud.controller;

import com.wzs.springcloud.pojo.CommentResult;
import com.wzs.springcloud.pojo.PayMent;
import com.wzs.springcloud.server.impl.PayServerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PayController {
    @Autowired
    private PayServerImpl payserver;
    @Value("${server.port}")
    private String ServerPort;

    @GetMapping("/get/{id}")
    public CommentResult getPayMent(@PathVariable("id")long id){
        log.info("into select byid ServerPort:"+this.ServerPort);
        PayMent payment= payserver.queryById(id);
        if(!StringUtils.isEmpty(payment)){
            log.info("select success");
           return  new CommentResult<>(200,"支付状态信息为:",payment);
        }
        else {
            log.info("select failed");
            return new CommentResult<>(404,"not find source",id);
        }

    }

    @GetMapping("/get/list")
    public CommentResult getPayMentAll(){
        log.info("into select allpayment ServerPort:"+this.ServerPort);
        List<PayMent> payMentList = payserver.queryAll();
        if(!StringUtils.isEmpty(payMentList)){
            log.info(" select allpayment success");
            return  new CommentResult<>(200,"支付状态信息为:",payMentList);
        }
        else {
            log.info(" select allpayment failed");
            return new CommentResult<>(404,"not find source","noinfo");
        }

    }

    @PostMapping("/create")
    public CommentResult CreatePayMent( @RequestBody PayMent payMent){
        log.info("into create payment ServerPort:"+this.ServerPort);
        int result= payserver.create(payMent);
        if(result>0){
            log.info("create payment success");
            return  new CommentResult<>(200,"添加成功:",result);
        }
        else {
            log.info(" create payment failed");
            return new CommentResult<>(404,"insert failed",result);
        }

    }

    @GetMapping("/get/port")
    public String getServerPort(){
        return  "server provider port:"+ServerPort;
    }
    @GetMapping("/timeout/port")
    public String getPort(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            log.error(String.valueOf(e));
        }
        return  "server provider port:"+ServerPort;
    }
}
