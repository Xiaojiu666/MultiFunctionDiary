package com.sn.diary.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static boolean isToday(long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");// HH:mm:ss
//获取当前时间
        Date date = new Date(System.currentTimeMillis());
        if(time>=getStringToDate(simpleDateFormat.format(date))){
            return true;
        }
        return false;
    }
    public static boolean isYesToday(long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");// HH:mm:ss
//获取当前时间
        Date date = new Date(System.currentTimeMillis());
            if(time>=getStringToDate(simpleDateFormat.format(date))-86400){
                return true;
                }
        return false;
    }
    /*将字符串转为时间戳*/
    public static long getStringToDate(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date();
        try{
            date = sdf.parse(time);
        } catch(ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime()/1000;
    }

    /*时间戳转换成字符窜*/
    public static String getDateToString(long time) {
        Date d = new Date(time*1000);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
        return sf.format(d);
    }
}
