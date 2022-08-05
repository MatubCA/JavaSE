package com.dong;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ClassName: com.dong.ListDemo3
 * date: 2022/8/4 18:29
 * Description: 对集合元素的排序
 *
 * @author 苏无及
 * @since JDK 8
 */
public class ListDemo3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(13);
        list.add(14);
        list.add(89);
        list.add(5);

        /*list.sort(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });*/

        list.sort((o1,o2) -> o1 - o2);

        list.forEach(System.out::println);
    }
}
