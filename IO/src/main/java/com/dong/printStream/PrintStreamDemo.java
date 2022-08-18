package com.dong.printStream;/*
 * ClassName: com.dong.printStream.PrintStreamDemo
 * date: 2022/8/14 10:53
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.io.*;
import java.util.Scanner;

public class PrintStreamDemo {


    public static void printStreamMethod(){
        PrintWriter print = null;
        try {
            print = new PrintWriter(new FileOutputStream("a.txt",true),true);
            print.println("大魔王");
            print.println(9999);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (print != null)
                print.close();

        }
    }

    public static void printStreamMethod2(){
        PrintStream print = null;
        try {
            print = new PrintStream(new FileOutputStream("a.txt",true),true);
            System.setOut(print);
            System.out.println("haha");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (print != null)
                print.close();

        }
    }

    public static void  printStreamMethod3(){
        System.out.println("输入用户名和密码(以exit结束):");
        BufferedReader bufferedReader = null;
        String str = null;
        PrintWriter print = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            print = new PrintWriter(new FileOutputStream("a.txt"),true);
            while ((str = bufferedReader.readLine()) != null) {
                if (str.equals("exit")) {
                    System.out.println("exit!");
                    break;
                } else {
                    System.out.println(str);
                    System.out.println("继续输入:");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }




}
