package org.example.service.controller;

import org.example.myI18n.spring.boot.autoconfigure.utils.MessageUtils;
import org.example.service.client.ServiceBFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

/**
 * Created by heqingfu on 2020/2/16.
 */
@RestController
public class ServiceAController {

    @Autowired
    private ServiceBFeignClient serviceBFeignClient;


    @GetMapping(value = "/getServiceName")
    public String getServiceName(HttpServletRequest request) {

        System.out.println("request locale is " + request.getLocale());

        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);

        Locale locale = LocaleContextHolder.getLocale();
        System.out.println("session locale is " + locale);
        System.out.println("request session is " + request.getSession().getId());

        String bServiceName = serviceBFeignClient.getServiceName();
        return MessageUtils.get("service.name") + "\n" + bServiceName;
    }

    @GetMapping(value = "/hello")
    public String hello(@RequestParam("param") String param) {

        String bHello = serviceBFeignClient.hello(param);
        return MessageUtils.get("hello") + "\n" + bHello;
    }

    @PostMapping(value = "/world")
    public String world(@RequestBody List<String> paramList) {

        String bHello = serviceBFeignClient.world(paramList);
        return MessageUtils.get("hello") + "\n" + bHello;
    }
}
