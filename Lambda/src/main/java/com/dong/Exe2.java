package com.dong;

/**
 * ClassName: com.dong.Exe2
 * date: 2022/8/4 17:37
 * Description: 使用Lambda表达式引用构造方法 类名::new
 *
 * @author 苏无及
 * @since JDK 8
 */
public class Exe2 {
    public static void main(String[] args) {
        NoParamConstructor create = () -> new User();
        User user = create.getUser();
        System.out.println(user);

        NoParamConstructor create1 = User::new;
        User user1 = create1.getUser();
        System.out.println(user1);

        ParamConstructor create3 = User::new;
        User user2 = create3.getUser("张三", 22);
        System.out.println(user2);
    }
}

interface NoParamConstructor{
    User getUser();
}

interface ParamConstructor{
    User getUser(String name,int age);
}