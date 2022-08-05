package com.dong;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: com.dong.ListDemo
 * date: 2022/8/4 18:12
 * Description: Lambda表达式遍历集合
 *
 * @author 苏无及
 * @since JDK 8
 */
public class ListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("大白");
        list.add("小白");

        list.forEach(System.out::println);

        list.forEach(str -> {
            if (str.equals("大白")){
                System.out.println(true);
            }
        });
    }
}
