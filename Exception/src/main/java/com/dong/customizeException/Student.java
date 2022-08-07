package com.dong.customizeException;/*
 * ClassName: com.dong.demo.Student
 * date: 2022/8/7 18:02
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

public class Student {
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
        if (age >=18 && age <=25){
            this.age = age;
        }else{
            throw new AgeOutOfBoundsException("输入合法年龄!");
        }

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
