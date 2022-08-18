package com.dong.method;/*
 * ClassName: com.dong.method.Method_3
 * date: 2022/8/17 11:19
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.util.concurrent.Callable;

public class Method_1_3 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread thread = Thread.currentThread();
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println(thread.getName()+i);
            sum += i;
        }
        return sum;
    }
}
