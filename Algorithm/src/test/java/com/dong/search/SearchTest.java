package com.dong.search;/*
 * ClassName: com.dong.search.SearchTest
 * date: 2022/8/7 10:32
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import org.junit.Test;

public class SearchTest {

    /*
        测试二分查找
     */
    @Test
    public void test1(){
        Search search = new Search();
        System.out.println(search.binarySearch(new int[]{1,2,3,4,5,5,6}, 5));
    }
}
