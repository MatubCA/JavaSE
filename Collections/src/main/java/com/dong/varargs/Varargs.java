package com.dong.varargs;/*
 * ClassName: com.dong.varargs.Varargs
 * date: 2022/8/11 17:51
 * Description: 可变长参数
 * @author 苏无及
 * @version
 * @since JDK 8
 */

public class Varargs {
    // 本质上就是一个参数数组
    public static int getSum(int... args){
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }

    // 普通参数要放在可变长参数之前,否则传入的参数都将进入可变长参数
    public static int getSum(char i,int... args){
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum + i;
    }
}
