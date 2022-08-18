package com.dong.Map;/*
 * ClassName: com.dong.Map.MapDemo
 * date: 2022/8/10 20:57
 * Description:
 * @author 苏无及
 * @version
 * @since JDK 8
 */

import java.util.Objects;

public class MapDemo {
}

class Student implements Comparable<Student> {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student user2 = (Student) o;

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

    @Override
    public int compareTo(Student o) {
        int result = this.age - o.age;
        return result == 0 ? this.name.compareTo(o.name) : result;
    }
}
