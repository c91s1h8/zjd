package com.demo.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author csh
 * @Description: TODO
 * @Date 2023-1-29 15:42
 */

@SpringBootApplication(scanBasePackages = "com.demo")
@MapperScan("com.demo.*.mapper")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.demo.api")
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
