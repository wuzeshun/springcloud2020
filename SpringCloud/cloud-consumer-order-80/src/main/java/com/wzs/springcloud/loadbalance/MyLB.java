package com.wzs.springcloud.loadbalance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MyLB implements MyLoadBalance{
    private  AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 计算rest次数，并返回给getInstance（）方法使用
     * @return
     */
    public  final int getAndIncrement()
    {
        int current;
        int next;
        do{
            //当前rest次数
            current=this.atomicInteger.get();

            next = current >= 2147483647 ? 0 : current+1;

        //自旋，CAS锁修改atomicInteger的值，成功则返回true，失败返回false
        }while(!this.atomicInteger.compareAndSet(current,next));
        System.out.println("rest 次数为:"+next);
        return next;
    }

    /**
     * 返回具体的服务对象
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance getInstance(List<ServiceInstance> serviceInstances) {
        //具体的服务在服务列表中的下标
        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
