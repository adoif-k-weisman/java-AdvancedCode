package com.itheima.myservlet;

import com.itheima.httpserver.HttpRequest;
import com.itheima.httpserver.HttpResponse;

/**
 * 规范servlet类的
 */
public interface HttpServlet {

    //定义业务处理的方法
    public abstract void service(HttpRequest httpRequest, HttpResponse httpResponse);
}
