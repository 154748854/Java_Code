package com.example.springblog.demos.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String DateFormat(Date date) {
        // 2025-05-23 21:31
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }
}
