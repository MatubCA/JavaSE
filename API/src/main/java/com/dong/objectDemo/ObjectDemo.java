package com.dong.objectDemo;/*
 * ClassName: com.dong.objectDemo.ObjectDemo
 * date: 2022/8/9 15:37
 * Description: 对于Object中方法的测试
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.util.Objects;

public class ObjectDemo {
}


// 没有重写equals和hashCode方法
class User {
    private String name;
    private Integer age;

    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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


// 只重写equals方法
class User2 {
    private String name;
    private Integer age;

    public User2() {
    }

    public User2(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        User2 user = (User2) obj;
        return Objects.equals(user.age, this.age) && Objects.equals(name, user.name);
    }
}


// 重写equals和hashCode方法
class User3 {
    private String name;
    private Integer age;

    public User3() {
    }

    public User3(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        User3 user = (User3) obj;
        return Objects.equals(user.age, this.age) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}


