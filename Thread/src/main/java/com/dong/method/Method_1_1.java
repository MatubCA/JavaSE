package com.dong.method;/*
 * ClassName: com.dong.method.Method_1
 * date: 2022/8/17 11:00
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

public class Method_1_1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName()+i);
        }
    }
}
