package com.dong.Map;/*
 * ClassName: com.dong.Map.MapDemoTest
 * date: 2022/8/10 20:57
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Properties;
import java.util.TreeMap;

public class MapDemoTest {

    @Test
    public void test(){
        Properties properties = new Properties();
        properties.setProperty("一号嘉宾","吴彦祖");
        properties.setProperty("二号嘉宾","彭于晏");
        properties.put("三号嘉宾","吴哥");
        System.out.println(properties.getProperty("一号嘉宾"));
        System.out.println(properties.getProperty("二号嘉宾"));
        System.out.println(properties.get("三号嘉宾"));

        properties.forEach((key,value) ->{
            System.out.println(key + "=" + value);
        });
    }

    @Test
    public void test2() {
        HashMap<Student, String> map = new HashMap<>();
        map.put(new Student("张三",20),"西安");
        map.put(new Student("李四",21),"上海");
        map.put(new Student("王五",22),"华盛顿");
        map.put(new Student("王五",18),"华盛顿");
        map.put(new Student("王五",15),"华盛顿");
        map.put(new Student("王五",30),"华盛顿");

        map.forEach((key,value) ->{
            System.out.println(key+"=="+value);
        });
    }

    @Test
    public void test3(){
        TreeMap<Student, String> map = new TreeMap<>();
        map.put(new Student("张三",20),"西安");
        map.put(new Student("李四",21),"上海");
        map.put(new Student("王五",22),"华盛顿");
        map.put(new Student("王五",18),"华盛顿");
        map.put(new Student("王五",15),"华盛顿");
        map.put(new Student("aa",30),"华盛顿");
        map.put(new Student("bb",30),"华盛顿");
        map.put(new Student("cc",30),"华盛顿");

        map.forEach((key,value) ->{
            System.out.println(key +"=="+ value);
        });
    }

}
