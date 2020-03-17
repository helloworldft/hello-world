package org.example.i18n.custom;

import org.example.myI18n.spring.boot.autoconfigure.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;

import javax.validation.Valid;

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
        System.out.println(org.example.i18n.custom.MessageUtils.get("hello"));
        return MessageUtils.get("hello");
    }

    @PostMapping("/world")
    public String world(@Valid @RequestBody User user, BindingResult result) {
        System.out.println(org.example.i18n.custom.MessageUtils.get("hello"));

        if (result.hasErrors()) {
            return result.getAllErrors().get(0).getDefaultMessage();
        }
        return MessageUtils.get("hello");
    }


}
