package org.example.myI18n.spring.boot.autoconfigure;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by heqingfu on 2020/2/16.
 */

public class FeignConfiguration implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
//                .getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        //传递lang
//        String lang = request.getParameter("lang");
//        if (!StringUtils.isEmpty(lang)) {
//            template.query("lang", lang);
//        } else {
//            //从session中获取locale
//            Locale locale = LocaleContextHolder.getLocale();
//            if (locale != null) {
//
//                template.query("lang", locale.toString());
//            }
//        }


        Locale locale = LocaleContextHolder.getLocale();
        if (locale != null) {
            template.query("lang", locale.toString());
        }
    }
}
