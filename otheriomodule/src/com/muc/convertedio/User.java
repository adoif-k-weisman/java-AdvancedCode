package com.muc.convertedio;

import java.io.Serializable;

//如果想要这个类的对象能被序列化,那么这个类必须要实现一个接口.Serializable

//Serializable 接口的意义
//称之为是一个标记性接口,里面没有任何的抽象方法
//只要一个类实现了这个Serializable接口,那么就表示这个类的对象可以被序列化.
public class User implements Serializable {
    //serialVersionUID 序列号
    //如果我们自己没有定义,那么虚拟机会根据类中的信息会自动的计算出一个序列号.
    //问题:如果我们修改了类中的信息.那么虚拟机会再次计算出一个序列号.

    //第一步:把User对象序列化到本地.(会把序列号写入到本地去) --- -5824992206458892149
    //第二步:修改了javabean类. 导致 --- 类中的序列号更改为： 4900133124572371851
    //第三步:把文件中的对象读到内存. 本地中的序列号和类中的序列号不一致了.

    //解决?
    //不让虚拟机帮我们自动计算,我们自己手动给出.而且这个值不要变.

    //自己写一个序列号
    private static final long serialVersionUID = 1L;

    private String username;
    private transient String password;//transient关键字：被修饰的成员变量不参与序列化过程,就不会写入本地文件

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
