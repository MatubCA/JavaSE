package com.dong.Collection;/*
 * ClassName: com.dong.Collection.Demo
 * date: 2022/8/9 10:23
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import org.junit.Test;

import java.util.ArrayList;

public class Demo {

    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int temp = list.size();
        while(i < 10){
            list.add(temp / 2,i);
            i++;
        }
        list.forEach(System.out::println);
    }
}
