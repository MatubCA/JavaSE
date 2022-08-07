package com.dong.else1;/*
 * ClassName: com.dong.else1.Else1
 * date: 2022/8/7 11:48
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

public class Else1 {

    public String getString(int[] arr){
        /*
         * Description: 打印数组
         * @author: 苏无及
         * @date: 2022/8/7 12:06
         * @param:[arr]
         * @return:java.lang.String
         */
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                result += arr[i];
                break;
            }
            result += arr[i] + ", ";
        }
        result += "]";
        return result;
    }

    public String getString(String str) {
        /*
         * Description: 给一个字符串,数字在左边,字母在右边
         * @author: 苏无及
         * @date: 2022/8/7 12:28
         * @param:[str]
         * @return:java.lang.String
         */
        StringBuilder number = new StringBuilder();
        StringBuilder string = new StringBuilder();
        StringBuilder elseStr = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >'0' && str.charAt(i) <'9') {
                number.append(str.charAt(i));
            }else if(str.charAt(i) >'z' && str.charAt(i) <'a' || str.charAt(i) >'Z' && str.charAt(i) <'A'){
                string.append(str.charAt(i));
            }else{
                elseStr.append(str.charAt(i));
            }
        }
        return number.append(string).append(elseStr).toString();
    }
}
