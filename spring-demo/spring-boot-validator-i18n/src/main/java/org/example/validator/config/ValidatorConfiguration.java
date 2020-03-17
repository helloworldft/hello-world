package org.example.validator.config;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.springframework.boot.validation.MessageInterpolatorFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validation;
import javax.validation.Validator;


/**
 * Created by heqingfu on 2020/2/20.
 */
@Configuration
public class ValidatorConfiguration {

//    @Bean
//    public LocalValidatorFactoryBean getValidator(MessageSource messageSource) {
//
////        LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
////        validator.setValidationMessageSource(messageSource);
////        System.out.println(validator.toString());
////        return validator;
//        System.out.println("1234");
//
//        LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
//        MessageInterpolatorFactory interpolatorFactory = new MessageInterpolatorFactory();
//        factoryBean.setMessageInterpolator(interpolatorFactory.getObject());
//        factoryBean.setValidationMessageSource(messageSource);
//        System.out.println(factoryBean.toString());
//        return factoryBean;
//
//    }



}
