package com.dong.exceptionDemo;/*
 * ClassName: com.dong.exceptionDemo.CommonExceptionTest
 * date: 2022/8/6 19:20
 * Description: 常见异常演示
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import org.junit.Test;

public class CommonExceptionTest {

    /*
        测试数组索引越界
     */
    @Test
    public void test1(){
        CommonException exception = new CommonException();
        exception.indexOutExp();
    }

    /*
        测试空指针异常
     */
    @Test
    public void test2(){
        CommonException exception = new CommonException();
        exception.nullRef();
    }

    /*
        测试算数异常
     */
    @Test
    public void test3(){
        CommonException exception = new CommonException();
        exception.divideZero();
    }

    /*
        测试类型转换错误
     */
    @Test
    public void test4(){
        CommonException exception = new CommonException();
        exception.convert();
    }


}
