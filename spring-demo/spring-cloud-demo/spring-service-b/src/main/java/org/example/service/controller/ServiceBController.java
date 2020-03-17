package org.example.service.controller;

import org.example.service.client.ServiceCFeignClient;
import org.example.service.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by heqingfu on 2020/2/16.
 */
@RestController
public class ServiceBController {


    @Autowired
    private ServiceCFeignClient serviceCFeignClient;

    @GetMapping(value = "/getServiceName")
    public String getServiceName(HttpServletRequest request) {

        System.out.println("request locale is " + request.getLocale());
        System.out.println("request session is " + request.getSession().getId());

        String cServiceName = serviceCFeignClient.getServiceName();
        return MessageUtils.get("service.name") + "\n" + cServiceName;
    }

    @GetMapping(value = "/hello")
    public String hello(@RequestParam("param") String param) {

        String bHello = serviceCFeignClient.hello(param);
        return MessageUtils.get("hello") + "\n" + bHello;
    }
    @PostMapping(value = "/world")
    public String world(@RequestBody List<String> paramList) {

        String bHello = serviceCFeignClient.world(paramList);
        return MessageUtils.get("hello") + "\n" + bHello;
    }
}
