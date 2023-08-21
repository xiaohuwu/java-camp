package com.ktb.config;


import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class String2DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if (StringUtils.hasText(source)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            try {
                return dateFormat.parse(source);
            } catch (ParseException e) {
                return null;
            }
        }
        return null;
    }
}
