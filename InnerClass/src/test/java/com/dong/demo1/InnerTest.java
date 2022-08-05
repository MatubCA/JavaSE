package com.dong.demo1;

import org.junit.Test;

/**
 * ClassName: com.dong.demo1.InnerTest
 * date: 2022/8/4 14:30
 * Description:
 *
 * @author 苏无及
 * @since JDK 8
 */
public class InnerTest {

    /*
        测试成员内部类
     */
    @Test
    public void test1(){
        InnerClass1.ClassDemo classDemo = new InnerClass1().new ClassDemo();
        classDemo.say();
    }
}
