package com.dong.demo;/*
 * ClassName: com.dong.demo.Demo_1_1
 * date: 2022/8/17 14:58
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

public class Demo_1_1 implements Runnable {
    private Integer ticketCount = 100;
    @Override
    public void run() {
        while (true) {
            // 使用同一个锁对象,不能new对象
          synchronized (this){
              if (ticketCount <= 0) {
                  break;
              } else {
                  ticketCount--;
                  System.out.println(Thread.currentThread().getName() + ": " + ticketCount);
              }
          }
        }
    }
}

