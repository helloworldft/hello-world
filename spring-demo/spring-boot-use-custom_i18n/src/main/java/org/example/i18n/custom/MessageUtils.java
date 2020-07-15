//package org.example.i18n.custom;
//
//import org.springframework.context.MessageSource;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.stereotype.Component;
//
//import java.util.Locale;
//
///**
// * Created by heqingfu on 2020/2/11.
// */
//@Component
//public class MessageUtils {
//    private static MessageSource messageSource;
//
//    public MessageUtils(MessageSource messageSource) {
//        MessageUtils.messageSource = messageSource;
//    }
//
//    /**
//     * 获取单个国际化翻译值
//     */
//    public static String get(String msgKey) {
//        try {
//            return messageSource.getMessage(msgKey, null, LocaleContextHolder.getLocale());
//        } catch (Exception e) {
//            return messageSource.getMessage(msgKey, null, Locale.US);
//        }
//    }
//}
