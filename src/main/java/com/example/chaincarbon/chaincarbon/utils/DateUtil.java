package com.example.chaincarbon.utils;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date parseTime(Date date){
        if (date==null) return null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        ParsePosition pos = new ParsePosition(8);
        return formatter.parse(dateString, pos);
    }
}
