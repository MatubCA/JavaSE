package com.dong;

/**
 * ClassName: com.dong.Exe1
 * date: 2022/8/4 17:03
 * Description: Lambda表达式引用方法 类名/对象名::方法名
 *
 * @author 苏无及
 * @since JDK 8
 */
public class Exe1 {

    public static void main(String[] args) {
        ReturnOneParam returnOneParam1 = num -> method1(num);
        System.out.println(returnOneParam1.method(99));

        ReturnOneParam returnOneParam2 = Exe1::method1;
        System.out.println(returnOneParam2.method(99));

        Exe1 exe1 = new Exe1();
        ReturnMultiParam returnMultiParam2 = exe1::method2;
        System.out.println(returnMultiParam2.method(99, 1));
    }

    /*
        接口的实现方法,返回值与参数与接口方法一致
     */
    public static int method1(int num){
        return num+1;
    }

    public int method2(int arg1, int arg2){
        return arg1+arg2;
    }
}
