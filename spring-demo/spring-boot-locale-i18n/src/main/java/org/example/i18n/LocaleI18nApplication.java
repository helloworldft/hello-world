package org.example.i18n;

import org.example.i18n.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

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
     * 登陆页面
     */
    @GetMapping("/")
    public ModelAndView index() {

        return new ModelAndView("user/login");
    }

    /**
     * 输出文字
     */
    @GetMapping("/hello")
    public String hello() {

        System.out.println(env.getProperty("spring.messages.basename") );
        return MessageUtils.get("user.welcome");
    }
    /**
     * 输出文字
     */
    @GetMapping("/language")
    public String language() {
        return MessageUtils.get("biz.locale");
    }
}
