package org.example.myI18n.spring.boot.autoconfigure;

import org.example.myI18n.spring.boot.autoconfigure.utils.MessageUtils;
import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.validation.MessageInterpolatorFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * Created by heqingfu on 2020/2/17.
 */
@Configuration
public class MyI18nAutoConfiguration {

    @Bean
    public FeignConfiguration getFeignConfiguration() {
        return new FeignConfiguration();
    }

    //通过defaultValidator这个名字覆盖springboot提供的validator的默认defaultValidator bean
//    @Bean
//    public Validator myValidator(MessageSource messageSource) {
//
//        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
//        MessageInterpolatorFactory interpolatorFactory = new MessageInterpolatorFactory();
//        factoryBean.setMessageInterpolator(interpolatorFactory.getObject());
//        factoryBean.setValidationMessageSource(messageSource);
//        return factoryBean;
//    }

//    @Bean
//    public javax.validation.Validator validator(){
//        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
//                .configure()
//                .addProperty( "hibernate.validator.fail_fast", "true" )
//                .buildValidatorFactory();
//        return validatorFactory.getValidator();
//
//    }

    @Bean
    public MessageUtils getMessageUtils(MessageSource messageSource) {
        MessageUtils messageUtils = new MessageUtils(messageSource);
        return messageUtils;

    }




    /**
     * 默认解析器 其中locale表示默认语言
     */
    @Bean
    @ConditionalOnMissingBean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        return localeResolver;
    }

    /**
     * 默认拦截器 其中lang表示切换语言的参数名
     */
    @Bean
    public WebMvcConfigurer localeInterceptor() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
                localeInterceptor.setParamName("lang");
                registry.addInterceptor(localeInterceptor);
            }
        };
    }
}
