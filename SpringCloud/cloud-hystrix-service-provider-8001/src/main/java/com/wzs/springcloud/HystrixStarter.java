package com.wzs.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixStarter {
    public static void main(String[] args) {
        SpringApplication.run(HystrixStarter.class,args);
    }

    /**
     * 此配置是为了服务监控而配置，与服务容错本身无关，springcloud升级后的玩法，
     * servletRegistrationBean因为springboot的默认路径不是"/hystrix.stream"
     * 只要在自己的项目里配置上下面的servlet就可以了
     *
     * 编写Servlet：HystrixMetricsStreamServlet
     * 注册Servlet：new ServletRegistrationBean(hystrixMetricsStreamServlet)
     * 设置启动级别：servletRegistrationBean.setLoadOnStartup(1);
     * 设置url（访问路径）:servletRegistrationBean.addUrlMappings("/hystrix/stream");
     * 设置Servletname： servletRegistrationBean.setName("HystrixStream");
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistration(){
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(hystrixMetricsStreamServlet);
        servletRegistrationBean.setLoadOnStartup(1);
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        servletRegistrationBean.setName("HystrixStream");
        return servletRegistrationBean;
    }
}
