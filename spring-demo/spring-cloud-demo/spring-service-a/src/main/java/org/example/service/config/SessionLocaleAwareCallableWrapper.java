package org.example.service.config;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Locale;
import java.util.concurrent.Callable;

/**
 * Created by heqingfu on 2020/2/18.
 */
public class SessionLocaleAwareCallableWrapper implements HystrixCallableWrapper{
    @Override
    public <T> Callable<T> wrap(Callable<T> callable) {
        return new SessionLocaleAwareCallableWrapper.LocaleAwareCallable<>(callable, LocaleContextHolder.getLocale());
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
                LocaleContextHolder.setLocale(locale);
                return delegate.call();
            } finally {
                LocaleContextHolder.resetLocaleContext();
            }
        }
    }
}
