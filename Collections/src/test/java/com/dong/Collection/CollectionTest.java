package com.dong.Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * ClassName: com.dong.Collection.CollectionTest
 * date: 2022/8/3 20:27
 * Description: Collection集合的方法
 *
 * @author 苏无及
 * @since JDK 8
 */
public class CollectionTest {

    /*
        测试添加元素
        add(Object obj)
        addAll(Collection coll)
     */
    @Test
    public void test1() {
        List<String> list1 = new ArrayList<>();
        list1.add("大白");
        list1.add("小白");
        list1.forEach(System.out::println);

        List<String> list2 = new ArrayList<>();
        list2.add("大白");
        list2.add("小白");
        list2.forEach(System.out::println);

        list1.addAll(list2);
        list1.forEach(System.out::println);
    }

    /*
        测试有效元素的个数
        int size()
     */
    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("大白");
        list.add("小白");

        System.out.println(list.size());
    }

    /*
        测试清空集合
        void clear()
     */
    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
        list.add("大白");
        list.add("小白");

        list.clear();
        list.forEach(System.out::println);
    }

    /*
        测试是否是空集合
        Boolean isEmpty()
     */
    @Test
    public void test4() {
        List<String> list = new ArrayList<>();
        list.add("大白");
        list.add("小白");

        System.out.println(list.isEmpty());
    }

    /*
        测试是否包含某个元素
        boolean contains(Object obj)
        boolean containsAll(Collection coll)
     */
    @Test
    public void test5() {
        List<String> list = new ArrayList<>();
        list.add("大白");
        list.add("小白");

        List<String> list1 = new ArrayList<>();
        list1.add("大白");

        System.out.println(list.contains("大白"));
        System.out.println(list.containsAll(list1));
    }

    /*
        测试删除元素
        boolean remove(Object obj)删除第一次找到的元素
        boolean removeAll(Collection coll)括号里写自己,相当于清空
        boolean removeIf(Object obj) 根据条件删除，使用Lambda表达式
     */
    @Test
    public void test6() {
        List<String> list = new ArrayList<>();
        list.add("大白");
        list.add("小白");
        list.add("中白");

        List<String> list1 = new ArrayList<>();
        list1.add("大白");

        System.out.println(list.remove("大白"));
        System.out.println(list.removeAll(list1));
        list.removeIf((String str)->{
            return str.equals("小白");
        });
        list.forEach(System.out::println);
    }

    /*
        测试区两个集合的交集
        boolean retainAll(Collection coll)将结果存放在当前集合中
     */
    @Test
    public void test7() {
        List<String> list = new ArrayList<>();
        list.add("大白");
        list.add("小白");


        List<String> list1 = new ArrayList<>();
        list1.add("大白");
        list1.add("小白");

        System.out.println(list.retainAll(list1));
        list.forEach(System.out::println);
    }

    /*
        测试判断集合是否相等
        boolean equals(Object obj)
     */
    @Test
    public void test8() {
        List<String> list = new ArrayList<>();
        list.add("大白");
        list.add("小白");

        List<String> list1 = new ArrayList<>();
        list1.add("大白");
        list1.add("小白");

        System.out.println(list.equals(list1));
    }

    /*
        测试转化成对象数组
        Object[] toArray()
     */
    @Test
    public void test9() {
        List<String> list = new ArrayList<>();
        list.add("大白");
        list.add("小白");

        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));
    }

    /*
        测试获取结合对象的Hash值
        hashCode()
     */
    @Test
    public void test10() {
        List<String> list = new ArrayList<>();
        list.add("大白");
        list.add("小白");

        System.out.println(list.hashCode());
    }

    /*
        测试返回迭代器对象
        Iterator()
     */
    @Test
    public void test11() {
        List<String> list = new ArrayList<>();
        list.add("大白");
        list.add("小白");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
