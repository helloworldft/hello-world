package org.example.validator.controller;

import org.example.myI18n.spring.boot.autoconfigure.utils.MessageUtils;
import org.example.validator.DemoModel;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by heqingfu on 2020/2/20.
 */
@RestController
public class DemoController {


    @PostMapping("/demo")
    public String demo(@Validated @RequestBody DemoModel demoModel, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error.getDefaultMessage());
            }
            return "fail";
        }

        return "success";
    }

    @PostMapping("/demo-with-handler")
    public String demoWithHandler(@Validated @RequestBody DemoModel demoModel) {

        return "success";
    }

    @GetMapping("/hello")
    public String hello() {
        System.out.println(LocaleContextHolder.getLocale());
        //LocaleContextHolder.setLocale(new Locale("zh","CN"));
        return MessageUtils.get("hello");
    }

    @GetMapping("/init-locale")
    public String initLocale(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(LocaleContextHolder.getLocale());
        LocaleContextHolder.setLocale(new Locale("zh","CN"));

        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        localeResolver.setLocale(request, response, new Locale("zh","CN"));
        return "OK";
    }
}
