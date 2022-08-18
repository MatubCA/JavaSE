package com.dong.method;/*
 * ClassName: com.dong.method.Method_2_1
 * date: 2022/8/17 11:38
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

public class Method_2_1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName() + ": " + i );
        }
    }
}
