package com.dong.stream;/*
 * ClassName: com.dong.stream.EndStream
 * date: 2022/8/13 11:53
 * Description: Stream的终止操作
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.util.List;
import java.util.stream.Collectors;

public class EndStream {

    // foreach
    public void forEachDemo(List<String> list){
        list.stream().forEach(System.out::println);
    }

    // collect 收集流上元素 Collectors.toXXX()方法创建集合，存储元素
    public void collectDemo(List<String> list){
        List<String> list1 = list.stream().filter(s -> s.startsWith("张")).collect(Collectors.toList());
    }

    // count 返回流上元素个数
    public void countDemo(List<String> list){
        long count = list.stream().filter(s -> s.startsWith("张")).count();
    }

}
