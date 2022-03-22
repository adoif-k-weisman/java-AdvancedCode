package com.ieheima.java_exception;

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
        if(age >= 18 && age <= 25){
            this.age = age;
        }else{
            //自定义异常的目的:为了让异常信息更加的见名知意
            //throw new RuntimeException("年龄超出了范围");//这个异常涵盖范围太大了  这个自带的异常是只有构造方法，需要自己写具体的方法
            throw new AgeOutOfBoundsException("年龄超出了范围");
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
