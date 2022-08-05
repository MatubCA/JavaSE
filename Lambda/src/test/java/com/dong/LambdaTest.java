package com.dong;

import org.junit.Test;

/**
 * ClassName: com.dong.LambdaTest
 * date: 2022/8/4 16:17
 * Description:
 *
 * @author 苏无及
 * @since JDK 8
 */
public class LambdaTest {

    /*
        测试无参无返回值的接口方法
     */
    @Test
    public void test1(){
        NoReturnNoParam noReturnNoParam = () -> {
            System.out.println("hello");
        };
        noReturnNoParam.method();
    }

    /*
        测试一个参数无返回值的接口方法
     */
    @Test
    public void test2(){
        NoReturnOneParam noReturnoneParam = (a) -> {
            a += 1;
            System.out.println(a);
        };
        noReturnoneParam.method(9);
    }

    /*
        测试多个参数无返回值的接口方法
     */
    @Test
    public void test3(){
        NoReturnMultiParam noReturnmultiParam = (x,y) -> {
            System.out.println(x+y);
        };
        noReturnmultiParam.method(1,2);
    }

    /*
        测试一个参数有返回值的接口方法
     */
    @Test
    public void test4(){
        ReturnOneParam ReturnOneParam = a -> a + 1;

        System.out.println(ReturnOneParam.method(99));
    }

    /*
        测试无参有返回值的接口方法
     */
    @Test
    public void test5(){
        ReturnNoParam ReturnNoParam = () -> {
            return 11;
        };
        System.out.println(ReturnNoParam.method());
    }

    /*
        测试多个参数有返回值的接口方法
     */
    @Test
    public void test6(){
        ReturnMultiParam ReturnMultiParam = (x,y) -> {
            System.out.println(x+y);
            return x+y;
        };
        ReturnMultiParam.method(99,1);
    }



}
