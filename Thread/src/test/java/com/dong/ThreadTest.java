package com.dong;/*
 * ClassName: com.dong.ThreadTest
 * date: 2022/8/17 9:42
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import com.dong.create.Create_1;
import com.dong.create.Create_2;
import com.dong.create.Create_3;
import com.dong.method.*;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    /*
        测试创建线程的第一种方法
     */
    @Test
    public void test1(){
        // 3.在main方法中开启线程
        Create_1 thread = new Create_1();
        // 4.开启线程
        thread.start();
    }


    /*
        测试床架线程的第二种方法
     */
    @Test
    public void test2(){
        // 3.创建自定义类的对象
        Create_2 create_2 = new Create_2();
        // 4.将其作为形参传入Thread类的构造方法
        Thread thread = new Thread(create_2);
        //5.开启线程
        thread.start();
    }

    /*
        测试创建线程的第三种方法
     */
    @Test
    public void test3() throws ExecutionException, InterruptedException {
        // 3.创建自定义类对象
        Create_3 create_3 = new Create_3();
        // 4.创建FutureTask对象
        FutureTask<Integer> integerFutureTask = new FutureTask<>(create_3);
        // 5.创建Thread对象
        Thread thread = new Thread(integerFutureTask);
        // 6.开启线程
        thread.start();
        // 7.获取返回值
        integerFutureTask.get();
    }

    /*
        测试第一种方法的设置与获取线程名称
     */
    @Test
    public void test4(){
        Method_1_1 thread1 = new Method_1_1();
        thread1.setName("线程一");

        Method_1_1 thread2 = new Method_1_1();
        thread2.setName("线程二");

        thread1.start();
        thread2.start();
    }

    /*
        测试第二种方法的设置与获取线程名称
     */

    @Test
    public void test5(){
        Method_1_2 method_1 = new Method_1_2();
        Thread thread1 = new Thread(method_1,"线程一");

        Method_1_2 method_1_2 = new Method_1_2();
        Thread thread2 = new Thread(method_1_2,"线程二");

        thread1.start();
        thread2.start();
    }

    /*
        测试第三种方法的设置与获取线程名称
     */
    @Test
    public void test6() throws ExecutionException, InterruptedException {
        Method_1_3 method_3_1 = new Method_1_3();
        FutureTask<Integer> integerFutureTask1 = new FutureTask<>(method_3_1);
        Thread thread1 = new Thread(integerFutureTask1,"线程一");

        Method_1_3 method_3_2 = new Method_1_3();
        FutureTask<Integer> integerFutureTask2 = new FutureTask<>(method_3_2);
        Thread thread2 = new Thread(integerFutureTask2,"线程二");

        thread1.start();
        thread2.start();
        integerFutureTask1.get();
        integerFutureTask2.get();
    }

    /*
        测试获取与修改线程优先级的方法
     */
    @Test
    public void test7()  {
        Method_1_1 thread1 = new Method_1_1();
        // 设置优先级为1
        thread1.setPriority(1);
        thread1.setName("线程一");
        // 打印优先级
        System.out.println("优先级:"+thread1.getPriority());

        Method_1_1 thread2 = new Method_1_1();
        // 设置优先级为2
        thread2.setPriority(10);
        thread2.setName("线程二");
        System.out.println("优先级:"+thread2.getPriority());

        thread1.start();
        thread2.start();
    }

    /*
        测试守护线程
     */
    @Test
    public void test8() {
        Method_4_1 method_4_1 = new Method_4_1();
        method_4_1.setName("线程一");

        Method_4_2 method_4_2 = new Method_4_2();
        method_4_2.setName("线程二");
        // 设置为守护线程
        method_4_2.setDaemon(true);

        method_4_1.start();
        method_4_2.start();
    }

    /*
        测试睡眠方法
     */
    @Test
    public void test9()  {
        // 不能在单元测试中测试-->Test1.java
    }
}
