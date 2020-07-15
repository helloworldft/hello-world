package org.example.i18n.custom;

import org.example.myI18n.spring.boot.autoconfigure.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
@RestController
public class LocaleI18nApplication {

    @Autowired
    LocaleResolver localeResolver;


    @Autowired
    private Environment env;

    @Autowired
    private MessageSourceAutoConfiguration messageSourceAutoConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(LocaleI18nApplication.class, args);
    }


    /**
     * 输出文字
     */
    @GetMapping("/hello")
    public String hello() {
        System.out.println(MessageUtils.get("hello"));
        return MessageUtils.get("hello");
    }

    @PostMapping("/world")
    public String world(@Valid @RequestBody User user, BindingResult result) {
        System.out.println(MessageUtils.get("hello"));

        if (result.hasErrors()) {
            return result.getAllErrors().get(0).getDefaultMessage();
        }
        return MessageUtils.get("hello");
    }

    @GetMapping("/getI18n")
    public void getI18n(@RequestParam String param,
                          HttpServletRequest request, HttpServletResponse response) {
        try {
            LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
            localeResolver.setLocale(request, response, new Locale(param.split("_")[0], param.split("_")[1]));
        } catch(Exception ex) {
            System.out.println(ex);
        }


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
        request.getSession().invalidate();
        return sessionInfoMap;
    }

}
