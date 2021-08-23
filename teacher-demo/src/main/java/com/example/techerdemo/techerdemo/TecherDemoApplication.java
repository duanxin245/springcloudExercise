package com.example.techerdemo.techerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//开启openfeign支持
@EnableFeignClients
public class TecherDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TecherDemoApplication.class, args);
    }

}
