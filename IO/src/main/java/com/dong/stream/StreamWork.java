package com.dong.stream;/*
 * ClassName: com.dong.scz.Stream
 * date: 2022/8/13 11:26
 * Description: Stream的中间操作
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.util.List;
import java.util.stream.Stream;

public class StreamWork {

    // filter 过滤操作
    public void filterDemo(List<String> list){
        list.stream().filter(s -> s.startsWith("张")).forEach(System.out::println);
    }

    // limit 截取指定参数个数
    public void limitDemo(List<String> list){
        list.stream().limit(2).forEach(System.out::println);
    }

    // skip 跳过指定参数个数
    public void skipDemo(List<String> list){
        list.stream().skip(2).forEach(System.out::println);
    }

    // concat 静态方法，合并流
    public void concatDemo(List<String> list1,List<String> list2){
        Stream.concat(list1.stream(), list2.stream()).forEach(System.out::println);
    }

    // distinct 去除重复元素
    public void distinctDemo(List<String> list){
        list.stream().distinct().forEach(System.out::println);
    }
}
