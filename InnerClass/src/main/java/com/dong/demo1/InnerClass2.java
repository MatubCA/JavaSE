package com.dong.demo1;

/**
 * ClassName: com.dong.demo1.InnerClass2
 * date: 2022/8/4 14:40
 * Description: 局部内部类
 *
 * @author 苏无及
 * @since JDK 8
 */
public class InnerClass2 {

    public void test(){
        class ClassDemo{
            public void say(){
                System.out.println("hello");
            }
        }
    }
}
