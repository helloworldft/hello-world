package org.example.service.controller;

import org.example.service.utils.MessageUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by heqingfu on 2020/2/16.
 */
@RestController
public class ServiceCController {

    @GetMapping(value = "/getServiceName")
    public String getServiceName(HttpServletRequest request) {

        System.out.println("request locale is " + request.getLocale());
        System.out.println("request session is " + request.getSession().getId());
        return MessageUtils.get("service.name");
    }

    @GetMapping(value = "/hello")
    public String hello(@RequestParam("param") String param) {

        System.out.println(param);
        return MessageUtils.get("hello") ;
    }

    @PostMapping(value = "/world")
    public String world(@RequestBody List<String> paramList) {

        paramList.stream().forEach(System.out::println);
        return MessageUtils.get("hello") ;
    }
}
