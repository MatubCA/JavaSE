package com.dong.objectStream;/*
 * ClassName: com.dong.objectStream.ObjectStreamDemo
 * date: 2022/8/16 19:38
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.io.*;

public class ObjectStreamDemo {

    public static void method1() throws IOException {
        /**
         * Description: 使用writeObject方法达到对象序列化
         * @author: 苏无及
         * @date: 2022/8/16 19:40
         * @param:[]
         * @return:void
         */
        // 1. 创建需要序列化的对象
        Student student1 = new Student("张三", 20);
        // 2. 获得ObjectOutputStream对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\Desktop\\a.txt"));
        // 3. 调用writeObject方法
        oos.writeObject(student1);
    }

    public static void method2() throws ClassNotFoundException, IOException {
        /**
         * Description: 使用readObject方法达到对象的反序列化
         * @author: 苏无及
         * @date: 2022/8/16 19:48
         * @param:[]
         * @return:void
         */
        // 1. 获得ObjectInputStream对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\Desktop\\a.txt"));
        // 2. 调用readObject方法
        Student student = (Student) ois.readObject();

        System.out.println(student);
    }
}
