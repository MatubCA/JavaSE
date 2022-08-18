package com.dong.set;/*
 * ClassName: com.dong.set.SetDemo
 * date: 2022/8/10 11:26
 * Description: 自然排序
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.util.Objects;

public class SetDemo {
}
// 使自定义类实现Comparable接口,重写compareTo方法,制定排序规则
class User implements Comparable<User>{
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

    @Override
    public int compareTo(User o) {
        int result = this.age - o.age;
        return result == 0 ? this.name.compareTo(o.name): result;
    }
}


// 一个普通的javaBean,测试定制排序
class User1 {
    private String name;
    private Integer age;

    public User1() {
    }

    public User1(String name, Integer age) {
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


// hashSet重写equals和hashCode方法
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User2 user2 = (User2) o;

        if (!Objects.equals(name, user2.name)) return false;
        return Objects.equals(age, user2.age);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return 100;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

