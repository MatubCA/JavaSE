package com.dong.method;/*
 * ClassName: com.dong.method.Method_3_1
 * date: 2022/8/17 12:03
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

public class Method_3_1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + ": "+ i);

        }
    }
}
