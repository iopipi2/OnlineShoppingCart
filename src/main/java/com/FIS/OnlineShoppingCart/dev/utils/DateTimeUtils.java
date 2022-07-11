package com.FIS.OnlineShoppingCart.dev.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.nimbusds.jose.shaded.json.parser.ParseException;

public class DateTimeUtils {

    public static String DDHHMM = "ddHHmm";
    public static String DD_MM_YYYY = "dd/MM/yyyy";
    public static String DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";
    public static String DD_MM_YYYY_HH_MM = "dd/MM/yyyy HH:mm";
    public static String MM_YYYY = "MM/yyyy";
    public static String HH_MM_SS = "HH:mm:ss";

    public static Date parseDate(String date, String pattern) throws java.text.ParseException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(date);
    }

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    public static Date addMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    public static Date getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getYesterday(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public static long dateDiff(Date from, Date to) {
        return (to.getTime() - from.getTime()) / (24 * 60 * 60 * 1000);
    }


}