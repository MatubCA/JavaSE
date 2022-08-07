package com.dong.sort;
/*
 * ClassName: com.dong.sort.Sort
 * date: 2022/8/7 10:17
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

public class Sort {

    public int[] bubbleSort(int[] arr) {
        /*
         * Description: 冒泡排序
         * @author: 苏无及
         * @date: 2022/8/7 10:21
         * @param:[arr]
         * @return:int[]
         */
        // 用前一个和后一个进行比较
        for (int i = 0; i < arr.length - 1; i++) {
            // 排序完的不用管
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
