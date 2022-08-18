package com.dong.method;/*
 * ClassName: com.dong.method.Method_2
 * date: 2022/8/17 11:13
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

public class Method_1_2 implements Runnable{
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            System.out.println(thread.getName()+i);
        }
    }
}
