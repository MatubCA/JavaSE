package com.dong.Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: com.dong.Collection.ListTest
 * date: 2022/8/4 8:22
 * Description: List新增方法 Lits使用索引,已索引区分相同的数据
 *
 * @author 苏无及
 * @since JDK 8
 */
public class ListTest {

    /*
        测试通过索引添加元素
        add(int index,Object obj)
        addAll(int index,Collection coll)
     */
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(0,"大白");
        list.add(1,"小白");
        list.add(2,"中白");

        for (Object o : list) {
            System.out.println(o);
        }

        List list1 = new ArrayList();
        list1.add("第四白");

        list.addAll(3,list1);

        for (Object o : list) {
            System.out.println(o);
        }
    }

    /*
        测试得到元素
        Object get(int index)
        int indexOf(Object obj)
        int lastIndexOf(Object obj)
     */
    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(0,"大白");
        list.add(1,"小白");
        list.add(2,"中白");
        list.add("大白");
        list.add("小白");
        list.add("中白");

        System.out.println(list.get(0));

        System.out.println(list.indexOf("大白"));

        System.out.println(list.lastIndexOf("大白"));
    }

    /*

     */
    @Test
    public void test3(){

    }
}
