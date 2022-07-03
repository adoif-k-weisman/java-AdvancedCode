package com.itheima.httpserver;

import com.itheima.myservlet.*;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * 执行动态资源类
 */
public class DynamicResourceProcess {

    //执行指定动态资源的service方法
    //参数一
    //由于后期可能根据用户请求的uri做出相应的处理.
    //参数二
    //要给用户响应数据,那么就需要使用到httpResponse.
    public void process(HttpRequest httpRequest,HttpResponse httpResponse){

        //获取请求的uri
        String requestURI = httpRequest.getRequestURI();

        //对requestURI进行切割操作
        String[] split = requestURI.split("\\?");

        //根据请求的uri到map集合中直接找到对应的servlet的对象
        HttpServlet httpServlet = ServletConcurrentHashMap.map.get(split[0]);
        System.out.println(httpServlet);

        if(httpServlet != null){
            //调用service方法对请求进行处理并响应
            httpServlet.service(httpRequest,httpResponse);
        }else{
            //浏览器请求的动态资源不存在
            //响应404
            response404(httpResponse);
        }




        /*//根据请求的uri进行判断
        if("/servlet/loginservlet".equals(requestURI)){
            //登录请求
            LoginServlet loginServlet = new LoginServlet();
            loginServlet.service(httpRequest,httpResponse);
        }else if("/servlet/registerservlet".equals(requestURI)){
            //注册请求
            RegisterServlet registerServlet = new RegisterServlet();
            registerServlet.service(httpRequest,httpResponse);
        }else if("/servlet/searchservlet".equals(requestURI)){
            //搜索商品请求
            SearchServlet searchServlet = new SearchServlet();
            searchServlet.service(httpRequest,httpResponse);
        }else{
            //表示默认处理方法
            //创建UserServlet对象,调用service方法,进行处理
            UserServlet userServlet = new UserServlet();
            userServlet.service(httpRequest,httpResponse);
        }*/
    }

    //浏览器请求动态资源不存在,响应404的方法
    private void response404(HttpResponse httpResponse) {
        try {
            //准备响应行
            String responseLine = "HTTP/1.1 404 NOT FOUND\r\n";
            //准备响应头
            String responseHeader = "Content-Type: text/html;charset=UTF-8\r\n";
            //准备响应空行
            String emptyLine = "\r\n";
            //拼接在一起
            String result = responseLine + responseHeader + emptyLine;

            //把响应行,响应头,响应空行去响应给浏览器
            SelectionKey selectionKey = httpResponse.getSelectionKey();
            SocketChannel channel = (SocketChannel) selectionKey.channel();

            ByteBuffer byteBuffer1 = ByteBuffer.wrap(result.getBytes());
            channel.write(byteBuffer1);

            //给浏览器 响应 响应体内容
            ByteBuffer byteBuffer2 = ByteBuffer.wrap("404 NOT FOUND....".getBytes());
            channel.write(byteBuffer2);

            //释放资源
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
