package com.dong.list;/*
 * ClassName: com.dong.list.ListDemo
 * date: 2022/8/8 15:02
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.util.List;

public class ListDemo {

    public static List<String> getList(List<String> list){
        /*
         * Description: 删除List中重复元素
         * @author: 苏无及
         * @date: 2022/8/8 15:08
         * @param:[list]
         * @return:java.util.List<java.lang.String>
         */
        for (int i = 0; i < list.size(); i++) {
            for (int i1 = i+1; i1 < list.size(); i1++) {
                if (list.get(i).equals(list.get(i1))){
                    list.remove(i);
                }
            }
        }
        return list;
    }
}
