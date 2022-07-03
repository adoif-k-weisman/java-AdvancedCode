package com.itheima.myservlet;

import com.itheima.httpserver.HttpRequest;
import com.itheima.httpserver.HttpResponse;

/**
 * 处理注册请求
 */
public class RegisterServlet implements HttpServlet{
    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
       //处理
        System.out.println("RegisterServlet处理了注册请求");


       //响应
        httpResponse.setContentTpye("text/html;charset=UTF-8");
        httpResponse.write("注册成功");
    }
}
