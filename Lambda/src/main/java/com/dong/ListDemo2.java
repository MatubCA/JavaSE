package com.dong;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: com.dong.ListDemo2
 * date: 2022/8/4 18:23
 * Description: 删除集合中的元素
 *
 * @author 苏无及
 * @since JDK 8
 */
public class ListDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("大白");
        list.add("小白");

        list.removeIf(str -> str.equals("大白"));

        list.forEach(System.out::println);
    }
}
