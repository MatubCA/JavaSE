package com.dong.stream;/*
 * ClassName: com.dong.stream.StreamDemo
 * date: 2022/8/13 10:40
 * Description: 获取Stream对象
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class ProcureStream {

    // list集合
    public void listDemo(List<String> list){
        list.stream().filter(s -> s.startsWith("张")).forEach(System.out::println);
    }

    // set集合
    public void setDemo(Set<String> set){
        set.stream().filter(s -> s.startsWith("张")).forEach(System.out::println);
    }

    // map集合
    public void mapDemo(Map<String, String> map){
            map.keySet().stream().filter(s -> s.startsWith("张")).forEach(System.out::println);
    }

    // map集合
    public void mapDemo2(Map<String,String> map){
        map.entrySet().stream().filter(entry-> entry.getKey().equals("张")).forEach(System.out::println);
    }

    // 数组
    public void arrayDemo(int[] arr){
        Arrays.stream(arr).filter(i -> i > 5).forEach(System.out::println);
    }

    // 普通参数
    public void paramDemo(String... args){
        Stream.of(args).filter(s -> s.startsWith("张")).forEach(System.out::println);
    }
}
