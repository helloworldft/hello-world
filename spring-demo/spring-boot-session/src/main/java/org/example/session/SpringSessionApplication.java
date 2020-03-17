package org.example.session;

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
@RestController
public class SpringSessionApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringSessionApplication.class, args);
    }

    /**
     * session测试
     * @param request
     * @return
     */
    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public Map<String, String> addSession (HttpServletRequest request){
        String sessionId = request.getSession().getId();
        String requestURI = request.getRequestURI() + ":"  +  request.getServerPort();
        // 向session中保存用户信息 key规则： user + "_" + uid
        request.getSession().setAttribute("user_1", "{uid:1,username:11@qq.com}");


        Map<String, String> sessionInfoMap = new HashMap<>(2);
        sessionInfoMap.put("sessionId", sessionId);
        sessionInfoMap.put("requestURI", requestURI);
        return sessionInfoMap;
    }
    /**
     * session测试
     * @param request
     * @return
     */
    @RequestMapping(value = "/getSession", method = RequestMethod.GET)
    public Map<String, String> getSession (HttpServletRequest request){
        String sessionId = request.getSession().getId();
        String requestURI = request.getRequestURI() + ":"  +  request.getServerPort();

        Map<String, String> sessionInfoMap = new HashMap<>(2);
        // 获取session中uid为1的用户的信息
        String user_1 = (String) request.getSession().getAttribute("user_1");

        sessionInfoMap.put("sessionId", sessionId);
        sessionInfoMap.put("requestURI", requestURI);
        sessionInfoMap.put("user_1", user_1);
        return sessionInfoMap;
    }
}
