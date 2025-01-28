package com.vinkaio.aitminiproject.svcc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
public class ServiceUtilC {
    @RequestMapping("/")
    String helloServiceC(){
        return "Hello World from Service C!";
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceUtilC.class, args);
    }
}