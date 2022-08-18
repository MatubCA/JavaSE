package com.dong.objectDemo;/*
 * ClassName: com.dong.objectDemo.ObjectDemoTest
 * date: 2022/8/9 15:48
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ObjectDemoTest {

    /*
        在自定义类中不重写equals和hashCode方法
     */
    @Test
    public void test1(){
        User user1 = new User("张三",20);
        User user2 = new User("张三",20);
        User user3 = user1;

        System.out.println(user1.equals(user1));
        System.out.println(user1.equals(user2));

        System.out.println(user1.hashCode() == user1.hashCode());
        System.out.println(user1.hashCode() == user2.hashCode());

        Set<User> set = new HashSet<>();
        set.add(user1);
        set.add(user2);
        set.add(user3);

        set.forEach(System.out::println);
    }

    /*
        测试在自定义类中只重写了equals方法,Set集合是否能去重
     */
    @Test
    public void test2() {
        User2 user1 = new User2("张三", 20);
        User2 user2 = new User2("张三", 20);

        Set<User2> set = new HashSet<>();
        set.add(user1);
        set.add(user2);

        set.forEach(System.out::println);
    }

    /*
        自定义类重写equals和hashCode方法
     */
    @Test
    public void test3() {
        User3 user1 = new User3("张三", 20);
        User3 user2 = new User3("张三", 20);

        Set<User3> set = new HashSet<>();
        set.add(user1);
        set.add(user2);

        set.forEach(System.out::println);
    }
}
