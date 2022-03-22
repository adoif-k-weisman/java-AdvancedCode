package com.ieheima.test_objects;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        //System.out.println("看看我执行了吗?");
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
