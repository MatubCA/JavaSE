package com.dong.create;/*
 * ClassName: com.dong.create.Create_2
 * date: 2022/8/17 10:04
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */


// 1.实现Runnable接口
public class Create_2 implements Runnable{
    // 2.重写run方法
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
