package com.itheima.myservlet;

import com.itheima.httpserver.HttpRequest;
import com.itheima.httpserver.HttpResponse;

/**
 * 处理查询商品请求
 */

public class SearchServlet implements HttpServlet{
    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
       //处理
        System.out.println("SearchServlet处理了搜索商品请求");


       //响应
        httpResponse.setContentTpye("text/html;charset=UTF-8");
        httpResponse.write("响应了一些商品信息");
    }
}
