package com.dong.demo;/*
 * ClassName: com.dong.demo.Demo_1_2
 * date: 2022/8/17 16:08
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo_1_2 implements Runnable {

    private Integer ticketCount = 100;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (ticketCount <= 0) {
                break;
            } else {
                ticketCount--;
                System.out.println(Thread.currentThread().getName() + ": " + ticketCount);
            }
        }
        lock.unlock();
    }
}

