package com.dong;/*
 * ClassName: com.dong.Demo
 * date: 2022/8/16 12:22
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class Demo {
    public static void main(String[] args) throws IOException {

        // 定义无参Properties集合
        Properties properties = new Properties();

        // 添加元素
        properties.setProperty("张三","桥东");
        properties.setProperty("李四","桥西");
        properties.setProperty("王五","桥南");

        // 根据key查找value
        System.out.println(properties.getProperty("张三"));
    }

    private static void propertiesIn1() throws IOException {

        // 使用getResourceAsStream方法得到配置文件的输入流
        InputStream inputStream = Demo.class.getResourceAsStream("/Demo.properties");

        Properties properties = new Properties();

        // 使用load方法加载输入流
        properties.load(inputStream);

        System.out.println(properties.getProperty("userName"));
        // 关闭资源
        if (inputStream != null) {
            inputStream.close();
        }

    }
}
