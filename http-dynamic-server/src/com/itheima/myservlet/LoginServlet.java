package com.itheima.myservlet;

import com.itheima.httpserver.HttpRequest;
import com.itheima.httpserver.HttpResponse;
import com.itheima.parse.WebServlet;

/**
 * 处理登录请求
 */
@WebServlet(urlPatterns = "/servlet/loginservlet")
public class LoginServlet implements HttpServlet{
    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
       //处理
        System.out.println("LoginServlet处理了登录请求");


       //响应
        httpResponse.setContentTpye("text/html;charset=UTF-8");
        httpResponse.write("登录成功");
    }
}
