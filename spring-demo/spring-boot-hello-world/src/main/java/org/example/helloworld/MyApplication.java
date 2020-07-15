package org.example.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by heqingfu on 2020/2/11.
 */



@SpringBootApplication
@RestController
public class MyApplication {




    public static void main(String[] args) {
        System.out.println("----------start--------");
        SpringApplication application = new SpringApplication(MyApplication.class);
        // ... customize application settings here
        application.run(args);
        System.out.println("----------end--------");
    }

    @Bean
    public Object myBean() {
        System.out.println("bean initialize");
        return new Object();
    }
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello (HttpServletRequest request){
        return "world";
    }

}
