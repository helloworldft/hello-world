package org.example.i18n.custom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

/**
 * Created by heqingfu on 2020/2/16.
 */
@Configuration
public class FeignConfiguration  {
    /**
     * 默认解析器 其中locale表示默认语言
     */
    @Bean
    public LocaleResolver localeResolver() {
        MyLocaleResolver localeResolver = new MyLocaleResolver();
        return localeResolver;
    }



}
