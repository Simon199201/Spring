package com.itheima.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String,Date> {
    public Date convert(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            sdf = new SimpleDateFormat("yyyy/MM/dd");
            try {
                return sdf.parse(dateStr);
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }
}
