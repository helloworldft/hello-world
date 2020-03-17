package org.example.i18n.custom;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.springframework.boot.validation.MessageInterpolatorFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.util.StringUtils;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Locale;

/**
 * Created by heqingfu on 2020/2/16.
 */
@Configuration
public class FeignConfiguration implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //传递lang
        String lang = request.getParameter("lang");
        if (!StringUtils.isEmpty(lang)) {
            template.query("lang", lang);
        } else {
            //从session中获取locale
            Locale locale = LocaleContextHolder.getLocale();
            if (locale != null) {

                template.query("lang", locale.toString());
            }
        }
    }



    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setDefaultEncoding("utf-8");//读取配置文件的编码格式
        source.setCacheMillis(-1);//缓存时间，-1表示不过期
        source.setBasename("ValidationMessages");//配置文件前缀名，设置为Messages,那你的配置文件必须以Messages.properties/Message_en.properties...
        return source;
    }


//    @Bean
//    public Validator validator() {
//
//
//        Validator validator = Validation.byDefaultProvider()
//                .configure()
//                .messageInterpolator(new ResourceBundleMessageInterpolator(new PlatformResourceBundleLocator("messages" )))
//                .buildValidatorFactory()
//                .getValidator();
//        validator
//        return validator;
//    }
//    @Bean
//    public ResourceBundleMessageSource getMessageSource() throws Exception {
//        ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
//        rbms.setDefaultEncoding("UTF-8");
//        rbms.setBasenames("messages");
//        return rbms;
//    }
//    @Bean
//    public Validator getValidator() throws Exception {
//        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
//        validator.setValidationMessageSource(getMessageSource());
//        return validator;
//    }
}
