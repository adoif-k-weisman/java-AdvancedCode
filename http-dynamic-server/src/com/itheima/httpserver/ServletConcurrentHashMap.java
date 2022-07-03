package com.itheima.httpserver;

import com.itheima.myservlet.HttpServlet;

import java.util.concurrent.ConcurrentHashMap;

public interface ServletConcurrentHashMap {

    //存储请求路径和对应的servlet的map集合
    //键: 请求的uri
    //值: 对应的Servlet对象
    public static final ConcurrentHashMap<String,  HttpServlet> map = new ConcurrentHashMap<>();
}
