package com.dong;

/**
 * ClassName: com.dong.User
 * date: 2022/8/4 17:40
 * Description:
 *
 * @author 苏无及
 * @since JDK 8
 */
public class User {
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
