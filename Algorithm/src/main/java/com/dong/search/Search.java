package com.dong.search;
/*
 * ClassName: com.dong.search.Search
 * date: 2022/8/7 10:08
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.util.Arrays;

public class Search {

    public int binarySearch(int[] arr,int num){
        /*
         * Description: 二分查找: 只能查找单个,数组先进行排序
         * @author: 苏无及
         * @date: 2022/8/7 10:00
         * @param:[arr, num]
         * @return:int
         */
        int min = 0;
        int max = arr.length - 1;
        while(min <= max) {
            int mid = (min + max) / 2;
            if (num == arr[mid]) {
                return mid;
            }else if (num > arr[mid]) {
                min = mid + 1;
            }else if (num < arr[mid]) {
                max = mid - 1;
            }
        }
        return -1;
    }
}
