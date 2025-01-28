package com.vinkaio.aitminiproject.svca;

import org.springframework.boot.SpringApplication;  
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class ServiceUtilA {
    @RequestMapping("/")
    String helloServiceA(){
        return "Hello World from Service A!";
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceUtilA.class, args);
    }
}