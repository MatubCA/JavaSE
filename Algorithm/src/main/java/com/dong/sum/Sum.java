package com.dong.sum;/*
 * ClassName: com.dong.sum.Sum
 * date: 2022/8/7 10:59
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

public class Sum {

    public int getSum(int num){
        /*
         * Description: 递归求和
         * @author: 苏无及
         * @date: 2022/8/7 11:02
         * @param:[num]
         * @return:int
         */
        if(num == 1){
            return 1;
        }else{
            return num + getSum(num - 1);
        }
    }
}
