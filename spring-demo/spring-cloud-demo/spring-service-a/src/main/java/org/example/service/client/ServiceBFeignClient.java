package org.example.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by heqingfu on 2020/2/16.
 */
@FeignClient("spring-service-b")
public interface ServiceBFeignClient {

    @RequestMapping("/getServiceName")
    String getServiceName();

    @RequestMapping("/hello")
    String hello(@RequestParam("param") String param);

    @RequestMapping("/world")
    String world(@RequestBody List<String> paramList);
}
