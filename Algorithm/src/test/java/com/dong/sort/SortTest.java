package com.dong.sort;/*
 * ClassName: com.dong.sort.SortTest
 * date: 2022/8/7 10:22
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import org.junit.Test;

import java.util.Arrays;

public class SortTest {

    /*
        测试冒泡排序
     */
    @Test
    public void test1(){
        Sort sort = new Sort();
        int[] ints = sort.bubbleSort(new int[]{4, 5, 2, 37, 1});
        System.out.println(Arrays.toString(ints));
    }
}
