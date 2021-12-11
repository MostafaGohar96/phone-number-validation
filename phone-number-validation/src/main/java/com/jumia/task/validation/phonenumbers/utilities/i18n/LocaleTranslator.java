package com.jumia.task.validation.phonenumbers.utilities.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class LocaleTranslator {
    private static ResourceBundleMessageSource messageSource;

    @Autowired
    public LocaleTranslator(ResourceBundleMessageSource messageSource) {
        LocaleTranslator.messageSource = messageSource;
    }

    public static String toLocale(String msgCode) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(msgCode, null, locale);
    }

    public static String toLocale(String msgCode, Object[] args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(msgCode, args, locale);
    }

    public static boolean isArabic(){
        return LocaleContextHolder.getLocale().getLanguage().equalsIgnoreCase("ar");
    }

    public static boolean isEnglish(){
        return LocaleContextHolder.getLocale().getLanguage().equalsIgnoreCase("en");
    }
}
