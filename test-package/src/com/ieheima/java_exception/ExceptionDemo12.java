package com.ieheima.java_exception;

import java.util.Scanner;

public class ExceptionDemo12 {
    public static void main(String[] args) {
        //键盘录入学生的姓名和年龄，其中年龄为18---25岁
        //超出这个范围是异常数据不能赋值，需要重新录入，一直录到正确为止
        Student s=new Student();

        Scanner sc=new Scanner(System.in);
        System.out.println("请输入姓名");
        String name=sc.nextLine();
        s.setName(name);
        //不适合写在这里，难道每写一个对象，都要重复写这段代码吗
        while(true) {
            System.out.println("请输入年龄");
            String ageStr = sc.nextLine();
            try {//这里可能出现读入的是字符
                int age = Integer.parseInt(ageStr);
                s.setAge(age);
                break;
            } catch (NumberFormatException e) {
                System.out.println("请输入一个整数");
                continue;
            }/*catch (RuntimeException e){
                System.out.println("请输入一个符合范围的年龄");
                continue;
            }*/
            catch(AgeOutOfBoundsException e){
                System.out.println(e.toString());//打印异常信息
                System.out.println("请输入一个符合范围的年龄");
                continue;
            }
            /*if(age>=18&&age<=25){
                s.setAge(age);
            }else{
                System.out.println("请输入符合要求的年龄:");
                continue;
            }*/
        }
        System.out.println(s);
        //s.setAge(age);
    }
}
