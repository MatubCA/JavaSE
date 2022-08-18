package com.dong;/*
 * ClassName: com.dong.Test
 * date: 2022/8/17 12:46
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import com.dong.create.Create_1;
import com.dong.demo.Demo_1_1;
import com.dong.demo.Demo_1_2;
import com.dong.method.Method_1_1;
import com.dong.method.Method_3_1;
import com.dong.method.Method_4_1;
import com.dong.method.Method_4_2;

public class Test {
}

/*
    测试睡眠方法
 */
class Test1 {
    public static void main(String[] args) {
        Method_3_1 method_3_1 = new Method_3_1();
        method_3_1.start();
    }
}

class Test2{
    public static void main(String[] args) {
        Method_4_1 method_4_1 = new Method_4_1();
        method_4_1.setName("线程一");

        Method_4_2 method_4_2 = new Method_4_2();
        method_4_2.setName("线程二");
        // 设置为守护线程
        method_4_2.setDaemon(true);

        method_4_1.start();
        method_4_2.start();
    }
}

class Test3 {
    public static void main(String[] args) {
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
}

/*
    测试synchronized
 */
class Test4{
    public static void main(String[] args) {
        Demo_1_1 demo_1_1 = new Demo_1_1();

        Thread thread1 = new Thread(demo_1_1);
        Thread thread2 = new Thread(demo_1_1);
        Thread thread3 = new Thread(demo_1_1);

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}


/*
    测试Lock
 */
class Test5{
    public static void main(String[] args) {
        Demo_1_2 demo_1_2 = new Demo_1_2();

        Thread thread1 = new Thread(demo_1_2);
        Thread thread2 = new Thread(demo_1_2);
        Thread thread3 = new Thread(demo_1_2);

        thread1.setName("窗口一");
        thread2.setName("窗口二");
        thread3.setName("窗口三");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}


