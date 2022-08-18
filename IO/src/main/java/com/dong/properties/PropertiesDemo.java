package com.dong.properties;
/*
 * ClassName: com.dong.properties.PropertiesDemo
 * date: 2022/8/16 18:22
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {

    public static void method1(){
        /**
         * Description: Properties的基本用法
         * @author: 苏无及
         * @date: 2022/8/16 19:11
         * @param:[]
         * @return:void
         */
        // 1. 创建properties集合
        Properties prop = new Properties();
        // 2. 添加元素
        prop.setProperty("张三","天津");
        prop.setProperty("李四","天津");
        prop.setProperty("王五","天津");

        // 3. 根据key获取value
        String name = prop.getProperty("张三");
        // 4. 获取所有key的Set集合
        Set<String> names = prop.stringPropertyNames();
        System.out.println(name);
        for (String s : names) {
            System.out.println(s);
        }
    }

    public static void method2() throws IOException {
        /**
         * Description: 使用store方法将properties集合中的元素写入properties文件中
         * @author: 苏无及
         * @date: 2022/8/16 19:17
         * @param:[]
         * @return:void
         */
        // 1. 获取properties集合
        Properties prop = new Properties();
        // 2. 添加元素
        prop.setProperty("张三","天津");
        prop.setProperty("李四","天津");
        prop.setProperty("王五","天津");
        // 3. 获得字符输出流
        FileWriter writer = new FileWriter("E:\\Desktop\\a.properties");
        // 4. 将集合元素写入文件
        prop.store(writer,null);
        // 5. 关闭资源
        writer.close();
    }

    public static void method3() throws IOException {
        /**
         * Description: 使用load方法将properties文件中的数据加载进properties集合的第一种方法
         * @author: 苏无及
         * @date: 2022/8/16 19:21
         * @param:[]
         * @return:void
         */
        // 1. 获得properties结合
        Properties prop = new Properties();
        // 2. 获得输入流
        FileReader reader = new FileReader("E:\\Desktop\\a.properties");
        // 3. 将文件中数据加载进properties集合中
        prop.load(reader);
        // 4 .关闭资源
        reader.close();

        String name = prop.getProperty("张三");
        System.out.println(name);
    }

    public static void method4() throws IOException {
        /**
         * Description: 使用load方法将properties文件中的数据加载进properties集合的第二种方式
         * @author: 苏无及
         * @date: 2022/8/16 18:46
         * @param:[]
         * @return:void
         */
        // 1. 获得properties集合
        Properties prop = new Properties();
        // 2. 获得输入流的第二种方式
        InputStream inputStream = PropertiesDemo.class.getResourceAsStream("/Demo.properties");
        // 3. 将文件中数据加载进properties集合中
        prop.load(inputStream);
        // 4. 关闭资源
        if (inputStream != null)
        inputStream.close();

        String userName = prop.getProperty("userName");
        System.out.println(userName);
    }
}
