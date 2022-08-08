package com.dong.date;/*
 * ClassName: com.dong.date.DateDemoTest
 * date: 2022/8/8 10:41
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import org.junit.Test;

import java.util.Date;

public class DateDemoTest {

    /*
        测试Date的无参构造
     */
    @Test
    public void test1(){
        System.out.println(DateDemo.getDate());
    }

    /*
        测试Date的有参构造
     */
    @Test
    public void test2(){
        System.out.println(DateDemo.getDate(0L));
    }

    /*
        测试getTime()方法
     */
    @Test
    public void test3(){
        System.out.println(DateDemo.getTime(new Date();));
    }

    /*
        测试getTime(long time)方法
     */
    @Test
    public void test4(){

    }
}
