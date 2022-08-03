package com.dong.entity;

/**
 * ClassName: com.dong.entity.Student
 * date: 2022/8/3 12:25
 * Description:
 *
 * @author 苏无及
 * @since JDK 8
 */
public class Student extends Person{
    private String name;
    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
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
    public void show() {
        System.out.println("!!");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
