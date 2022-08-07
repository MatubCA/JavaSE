package com.dong.customizeException;/*
 * ClassName: com.dong.demo.Test
 * date: 2022/8/7 18:04
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Student student = new Student();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入姓名:");
        String name = input.nextLine();
        student.setName(name);

        while (true) {
            System.out.println("请输入年龄:");
            String str = input.nextLine();
            try {
                int age = Integer.parseInt(str);
                student.setAge(age);
                break;
            } catch (NumberFormatException e) {
                System.out.println("请输入数字!");
            } catch (AgeOutOfBoundsException e) {// 捕获自定义异常
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println("添加成功!");
        System.out.println(student);


    }
}

