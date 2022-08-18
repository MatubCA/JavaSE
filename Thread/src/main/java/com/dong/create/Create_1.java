package com.dong.create;/*
 * ClassName: com.dong.create.Create_1
 * date: 2022/8/17 9:40
 * Description: 创建线程的第一种方法，继承Thread类
 * @author 苏无及
 * @version
 * @since JDK 8
 */

// 1.继承Thread类
public class Create_1 extends Thread{
    // 2.重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("thread"+i);
        }
    }
}
