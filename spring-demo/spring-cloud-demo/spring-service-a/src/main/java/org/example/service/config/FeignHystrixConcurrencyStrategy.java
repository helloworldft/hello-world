package org.example.service.config;

import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Locale;
import java.util.concurrent.Callable;

/**
 * Created by heqingfu on 2020/2/17.
 */
public class FeignHystrixConcurrencyStrategy extends HystrixConcurrencyStrategy {
    @Override
    public <T> Callable<T> wrapCallable(Callable<T> callable) {
        //return new RequestAttributeAwareCallable<>(callable, RequestContextHolder.getRequestAttributes());
        return new LocaleAwareCallable<>(callable, LocaleContextHolder.getLocale());
    }

    static class LocaleAwareCallable<T> implements Callable<T> {

        private final Callable<T> delegate;
        private final Locale locale;

        public LocaleAwareCallable(Callable<T> callable, Locale locale) {
            this.delegate = callable;
            this.locale = locale;
        }

        @Override
        public T call() throws Exception {
            try {
                //RequestContextHolder.setRequestAttributes(requestAttributes);
                LocaleContextHolder.setLocale(locale);
                return delegate.call();
            } finally {
                LocaleContextHolder.resetLocaleContext();
            }
        }
    }
}