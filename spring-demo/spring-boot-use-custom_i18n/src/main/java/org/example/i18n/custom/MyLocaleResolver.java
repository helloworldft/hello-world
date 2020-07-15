package org.example.i18n.custom;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.Optional;

/**
 * Created by heqingfu on 2020/6/17.
 */
@Configuration
public class MyLocaleResolver implements LocaleResolver {

    final static String HEADER_LANG = "lang";
    @Override
    public Locale resolveLocale(HttpServletRequest request) {


        String localeStr = request.getHeader(HEADER_LANG);
        if (!StringUtils.isEmpty(localeStr) && localeStr.split("_").length == 2) {
            return new Locale(localeStr.split("_")[0], localeStr.split("_")[1]);
        }

        return new Locale("zh", "CN");
    }

    @Override
    public void setLocale(HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable Locale locale) {
        Optional.ofNullable(locale).ifPresent(p -> response.setHeader(HEADER_LANG, p.toString()));
    }
}
