package com.dong.sum;/*
 * ClassName: com.dong.sum.SumTest
 * date: 2022/8/7 11:01
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import org.junit.Test;

public class SumTest {

    /*
        测试递归算法
     */
    @Test
    public void test1(){
        Sum sum = new Sum();
        System.out.println(sum.getSum(100));
    }
}
