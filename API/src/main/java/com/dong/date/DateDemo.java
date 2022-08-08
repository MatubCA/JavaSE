package com.dong.date;/*
 * ClassName: com.dong.date.DateDemo
 * date: 2022/8/8 10:38
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.util.Date;

public class DateDemo {

    public static Date getDate() {
        return new Date();
    }

    public static Date getDate(long time){
       return new Date(time);
    }

    public static long getTime(Date date){
        return date.getTime();
    }

    public static void setTime(Date date,long time){
        date.setTime(time);
    }


}
