//package org.example.service.config;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Enumeration;
//import java.util.Locale;
//
///**
// * Created by heqingfu on 2020/2/16.
// */
//@Configuration
//public class FeignConfiguration implements RequestInterceptor {
//    @Override
//    public void apply(RequestTemplate template) {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
//                .getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
////        //传递header信息
////        Enumeration<String> headerNames = request.getHeaderNames();
////        if (headerNames != null) {
////            while (headerNames.hasMoreElements()) {
////                String name = headerNames.nextElement();
////                String values = request.getHeader(name);
////                template.header(name, values);
////            }
////
////        }
//
//        //传递lang
//        String lang = request.getParameter("lang");
//        if (StringUtils.isNotEmpty(lang)) {
//            template.query("lang", lang);
//        } else {
//            //从session中获取locale
//            Locale locale = LocaleContextHolder.getLocale();
//            if (locale != null) {
//
//                template.query("lang", locale.toString());
//            }
//        }
//    }
//}
