package org.example.web.socket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by heqingfu on 2020/2/15.
 */
@SpringBootApplication
public class WebSocketApplication {


    public static void main(String[] args) {
        SpringApplication.run(WebSocketApplication.class, args);
    }


}
