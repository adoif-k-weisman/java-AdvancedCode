package com.itheima.myservlet;

import com.itheima.httpserver.HttpRequest;
import com.itheima.httpserver.HttpResponse;

/**
 * 处理浏览器请求动态资源的类
 */
public class UserServlet implements HttpServlet{

    //处理浏览器请求的方法
    //参数一
    //由于后期可能根据用户请求的uri做出相应的处理.
    //参数二
    //要给用户响应数据,那么就需要使用到httpResponse.
    public void service(HttpRequest httpRequest, HttpResponse httpResponse){

        //模拟业务处理  ---- 就可以对这个手机号进行判断验证
        System.out.println("UserServlet处理了用户的请求...");


        //给浏览器响应
        httpResponse.setContentTpye("text/html;charset=UTF-8");
        httpResponse.write("ok,UserServlet处理了本次请求....");
    }
}
