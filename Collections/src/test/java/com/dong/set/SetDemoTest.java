package com.dong.set;/*
 * ClassName: com.dong.set.SetDemoTest
 * date: 2022/8/10 11:27
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class SetDemoTest {

    /*
        测试TreeSet存储元素之实现接口
     */
    @Test
    public void test1(){
        User user1 = new User("小黑", 22);
        User user2 = new User("小白", 23);
        User user3 = new User("小红", 23);

        TreeSet<User> set = new TreeSet<>();
        set.add(user1);
        set.add(user2);
        set.add(user3);

        System.out.println(set);
    }

    /*
        测试TreeSet存储元素之比较器排序
     */
    @Test
    public void test2(){
        User1 user1 = new User1("小黑", 22);
        User1 user2 = new User1("小白", 23);
        User1 user3 = new User1("小白", 23);

        TreeSet<User1> set = new TreeSet<>(new Comparator<User1>() {
            @Override
            public int compare(User1 o1, User1 o2) {
                int result = o1.getAge() - o2.getAge();
                return result == 0 ? o1.getName().compareTo(o2.getName()) : result;
            }
        });

        set.add(user1);
        set.add(user2);
        set.add(user3);

        System.out.println(set);
    }


    /*
        测试HashSet存储元素所在类重写equals和hashCode方法
     */
    @Test
    public void test3() {
        User2 user1 = new User2("小黑", 22);
        User2 user2 = new User2("小白", 23);
        User2 user3 = new User2("小白", 23);
        User2 user4 = new User2("小黑", 23);

        HashSet<User2> hashSet = new HashSet<>();
        hashSet.add(user1);
        hashSet.add(user2);
        hashSet.add(user3);
        hashSet.add(user4);

        System.out.println(hashSet);
    }
    @Test
    public void test4() {
        HashSet<String> strings = new HashSet<>();
        strings.add("小黑");
        strings.add("小白");

        System.out.println(strings);
    }
}
