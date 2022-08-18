package com.dong.varargs;/*
 * ClassName: com.dong.varargs.VarargsTest
 * date: 2022/8/11 18:18
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import org.junit.Test;

public class VarargsTest {

    @Test
    public void test1(){
        int sum = Varargs.getSum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(sum);
        int sum1 = Varargs.getSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(sum1);
    }

    @Test
    public void test2() {
        int sum = Varargs.getSum('A', 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(sum);
    }
}
