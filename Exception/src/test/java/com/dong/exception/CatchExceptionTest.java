package com.dong.exception;/*
 * ClassName: com.dong.catchException.CatchExceptionTest
 * date: 2022/8/6 20:00
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import org.junit.Test;

public class CatchExceptionTest {

    /*
        测试捕获索引越界异常
     */
    @Test
    public void test1(){
        CatchException exception = new CatchException();
        exception.indexExp();
    }

    /*
        测试throw抛出异常
     */
    @Test
    public void test2(){
        CatchException exception = new CatchException();
        try {
            exception.throwIndexExp();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("数组索引越界");
        }
    }

    /*
        测试throws声明异常类型,交由调用者处理
     */
    @Test
    public void test3(){
        CatchException exception = new CatchException();
        try {
            exception.throwsIndexExp();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("数组索引越界!");
        }
    }

    /*
        测试finally
     */
    @Test
    public void test4(){
        CatchException exception = new CatchException();
        exception.finallyExp();
    }
}
