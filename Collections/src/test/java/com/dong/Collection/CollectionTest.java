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
    public void test1(){
        List list = new ArrayList();
        list.add("大白");
        list.add("小白");
        list.add("哈哈");
        list.add("薇薇");
        list.add("嘻嘻");
        list.add(88);

        List list1 = new ArrayList();
        list1.add("大白");
        list1.add("小白");
        list1.add("中白");

        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("===========================================");

        list1.addAll(list);
        for (Object o : list1) {
            System.out.println(o);
        }
        System.out.println("============================================");
    }

    /*
        测试有效元素的个数
        int size()
     */
    @Test
    public void test2(){
        List list = new ArrayList();
        list.add("大白");
        list.add("小白");
        list.add("哈哈");
        list.add("薇薇");
        list.add("嘻嘻");
        list.add(88);

        int size = list.size();
        System.out.println(size);
    }

    /*
        测试清空集合
        void clear()
     */
    @Test
    public void test3(){
        List list = new ArrayList();
        list.add("大白");
        list.add("小白");
        list.add("哈哈");
        list.add("薇薇");
        list.add("嘻嘻");
        list.add(88);

        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("==============================================");

        list.clear();
        int size = list.size();
        System.out.println(size);
    }

    /*
        测试是否是空集合
        Boolean isEmpty()
     */
    @Test
    public void test4(){
        List list = new ArrayList();
        list.add("大白");
        list.add("小白");
        list.add("哈哈");
        list.add("薇薇");
        list.add("嘻嘻");
        list.add(88);

        List list1 = new ArrayList();

        boolean empty = list.isEmpty();
        boolean empty1 = list1.isEmpty();
        System.out.println(empty);
        System.out.println(empty1);
    }

    /*
        测试是否包含某个元素
        boolean contains(Object obj)
        boolean containsAll(Collection coll)
     */
    @Test
    public void test5(){
        List list = new ArrayList();
        list.add("大白");
        list.add("小白");
        list.add("哈哈");
        list.add("薇薇");
        list.add("嘻嘻");
        list.add(88);

        List list1 = new ArrayList();
        list1.add("大白");
        list1.add("小白");
        list1.add("中白");

        boolean contains = list.contains("大白");
        boolean containsAll = list.containsAll(list1);
        System.out.println(contains);
        System.out.println(containsAll);
    }

    /*
        测试删除元素
        boolean remove(Object obj)删除第一次找到的元素
        boolean removeAll(Collection coll)括号里写自己,相当于清空
     */
    @Test
    public void test6(){
        List list = new ArrayList();
        list.add("大白");
        list.add("小白");
        list.add("哈哈");
        list.add("薇薇");
        list.add("嘻嘻");
        list.add(88);

        List list1 = new ArrayList();
        list1.add("大白");
        list1.add("小白");

        boolean remove = list.remove("哈哈");
        System.out.println(remove);
        boolean removeAll = list.removeAll(list1);
        System.out.println(removeAll);

        for (Object o : list) {
            System.out.println(o);
        }
    }

    /*
        测试区两个集合的交集
        boolean retainAll(Collection coll)将结果存放在当前集合中
     */
    @Test
    public void test7(){
        List list = new ArrayList();
        list.add("大白");
        list.add("小白");
        list.add("哈哈");
        list.add("薇薇");
        list.add("嘻嘻");
        list.add(88);

        List list1 = new ArrayList();
        list1.add("大白");
        list1.add("小白");

        boolean retainAll = list.retainAll(list1);
        System.out.println(retainAll);
        for (Object o : list) {
            System.out.println(o);
        }
    }

    /*
        测试判断集合是否相等
        boolean equals(Object obj)
     */
    @Test
    public void test8(){
        List list = new ArrayList();
        list.add("大白");
        list.add("小白");
        list.add("哈哈");
        list.add("薇薇");
        list.add("嘻嘻");
        list.add(88);

        List list1 = new ArrayList();
        list1.add("大白");
        list1.add("小白");

        boolean equals = list.equals(list1);
        System.out.println(equals);
    }

    /*
        测试转化成对象数组
        Object[] toArray()
     */
    @Test
    public void test9(){
        List list = new ArrayList();
        list.add("大白");
        list.add("小白");
        list.add("哈哈");
        list.add("薇薇");
        list.add("嘻嘻");
        list.add(88);

        Object[] objects = list.toArray();
        System.out.println(Arrays.toString(objects));
    }

    /*
        测试获取结合对象的Hash值
        hashCode()
     */
    @Test
    public void test10(){
        List list = new ArrayList();
        list.add("大白");
        list.add("小白");
        list.add("哈哈");
        list.add("薇薇");
        list.add("嘻嘻");
        list.add(88);

        System.out.println(list.hashCode());
    }

    /*
        测试返回迭代器对象
        Iterator()
     */
    @Test
    public void test11(){
        List list = new ArrayList();
        list.add("大白");
        list.add("小白");
        list.add("哈哈");
        list.add("薇薇");
        list.add("嘻嘻");
        list.add(88);

        Iterator iterator = list.iterator();
        System.out.println(iterator);
    }
}
