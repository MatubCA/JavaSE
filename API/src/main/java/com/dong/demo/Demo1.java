package com.dong.demo;/*
 * ClassName: com.dong.demo.Demo1
 * date: 2022/8/8 11:04
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo1 {

    public boolean isTime(String time) throws ParseException {
        String star = "2022/1/1 00:00:00";
        String end = "2022/1/1 00:10:00";
        SimpleDateFormat starTime = new SimpleDateFormat(star);
        SimpleDateFormat endTime = new SimpleDateFormat(end);

        Date date1 = starTime.parse(star);
        long time1 = date1.getTime();
        Date date2 = endTime.parse(end);
        long time2 = date2.getTime();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(time);
        Date parse = simpleDateFormat.parse(time);
        long time3 = parse.getTime();

        if (time3 >= time1 && time3 <=time2){
            return true;
        }
        return false;
    }
}
