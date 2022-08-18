package com.dong.systemIn;/*
 * ClassName: com.dong.systemIn.SystemIn
 * date: 2022/8/14 10:08
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemIn {
    public static void main(String[] args) {
        System.out.println("输入数据(以exit结束):");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            while ((str = bufferedReader.readLine()) != null) {
                if (str.equals("exit")) {
                    System.out.println("安全退出");
                    break;
                } else {
                    System.out.println(str.toUpperCase());
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

