package com.dong.else1;/*
 * ClassName: com.dong.else1.Else1Test
 * date: 2022/8/7 11:51
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import org.junit.Test;

public class Else1Test {

    /*
        测试打印int数组为字符串
     */
    @Test
    public void test1(){
        Else1 else1 = new Else1();
        System.out.println(else1.getString(new int[]{1, 2, 3}));
    }

    /*
        测试对字符串进行排序,数字在左边
     */
    @Test
    public void test2(){
        Else1 else1 = new Else1();
        System.out.println(else1.getString("1a2b3c"));
    }
}
