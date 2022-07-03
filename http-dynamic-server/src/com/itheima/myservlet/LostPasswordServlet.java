package com.itheima.myservlet;

import com.itheima.httpserver.HttpRequest;
import com.itheima.httpserver.HttpResponse;
import com.itheima.parse.WebServlet;

@WebServlet(urlPatterns = "/servlet/lostpasswordservlet")
public class LostPasswordServlet implements HttpServlet {

    public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
        //处理
        System.out.println("LostPasswordServlet处理了忘记密码请求");


        //响应
        httpResponse.setContentTpye("text/html;charset=UTF-8");
        httpResponse.write("重置密码成功");


    }
}
