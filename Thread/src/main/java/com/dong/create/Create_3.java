package com.dong.create;/*
 * ClassName: com.dong.create.Create_3
 * date: 2022/8/17 10:31
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.util.concurrent.Callable;

// 1.实现Callable接口
public class Create_3 implements Callable<Integer> {
    //2.重写call方法
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
        }
        return sum;
    }
}
