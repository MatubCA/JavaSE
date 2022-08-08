package com.dong.Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ClassName: com.dong.Collection.IteratorTest
 * date: 2022/8/3 21:01
 * Description: Iterator方法
 *
 * @author 苏无及
 * @since JDK 8
 */
public class IteratorTest {
    /*
        测试Iterator迭代器方法
        遍历集合
        boolean hashNext()
        Object next()
        remove()

         注意一个iterator只能遍历一次,指定移到最后,将不会自动返回原位.
         要想再次遍历只能再次获取iterator
     */
    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        list.add("大白");
        list.add("小白");
        list.add("哈哈");

        // 先使用hashNext()判断是否还有下一个元素
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals("大白")) {
                iterator.remove();
                System.out.println(iterator.next());
            }
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("大白");
        list.add("小白");
        list.add("哈哈");

        // 先使用hashNext()判断是否还有下一个元素
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals("大白")) {
                iterator.remove();
                System.out.println(iterator.next());
            }
            System.out.println(iterator.next());
        }
    }
}
