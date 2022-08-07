package com.dong.exceptionDemo;/*
 * ClassName: com.dong.exceptiondemo.CommonException
 * date: 2022/8/6 19:16
 * Description: 常见异常演示
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.util.Date;

public class CommonException {

    public void indexOutExp(){
        /*
         * Description: 数组索引越界异常 ArrayIndexOutOfBoundsException
         * @author: 苏无及
         * @date: 2022/8/6 19:23
         * @param:[]
         * @return:void
         */
        int[] array = {1,2,3,4,5};
        try {
            for (int i = 0; i < 6; i++) {
                System.out.println(array[i] + "");
            }
        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    public void nullRef(){
        /*
         * Description: 空指针异常 NullPointerException
         * @author: 苏无及
         * @date: 2022/8/6 19:27
         * @param:[]
         * @return:void
         */
        int[] array = {1,2,3};
        array = null;
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[1]);
        }
    }

    public void divideZero(){
        /*
         * Description: 算数异常 ArithmeticException
         * @author: 苏无及
         * @date: 2022/8/6 19:34
         * @param:[]
         * @return:void
         */
        int x = 0;
        int y = 3 / x;
        System.out.println(y);
    }

    public void convert(){
        /*
         * Description: 类型转换错误 ClassCastException
         * @author: 苏无及
         * @date: 2022/8/6 19:43
         * @param:[]
         * @return:void
         */
        Object date = new Date();
        CommonException exception = new CommonException();
        exception = (CommonException) date;
    }
}
