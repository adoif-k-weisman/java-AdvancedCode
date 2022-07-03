package com.itheima.httpserver;

import com.itheima.parse.LoaderResourceRunnable;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class HttpServer {
    public static void main(String[] args) throws IOException {

        //开启一条线程去解析配置文件
        new Thread(new LoaderResourceRunnable()).start();

        //1.打开服务端通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2.让这个通道绑定一个端口
        serverSocketChannel.bind(new InetSocketAddress(80));
        //3.设置通道为非阻塞
        serverSocketChannel.configureBlocking(false);
        //4.打开一个选择器
        Selector selector = Selector.open();

        //5.绑定选择器和服务端通道
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            //6.选择器会监视通道的状态.
            int count = selector.select();
            if (count != 0) {
                //7.会遍历所有的服务端通道.看谁准备好了,谁准备好了,就让谁去连接.
                //获取所有服务端通道的令牌,并将它们都放到一个集合中,将集合返回.
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    //selectionKey 依次表示每一个服务端通道的令牌
                    SelectionKey selectionKey = iterator.next();
                    if (selectionKey.isAcceptable()) {
                        //获取连接
                        AcceptHandler acceptHandler = new AcceptHandler();
                        acceptHandler.connSocketChannel(selectionKey);


                    } else if (selectionKey.isReadable()) {
                        //读取数据
                        HttpRequest httpRequest = new HttpRequest(selectionKey);
                        httpRequest.parse();
                        System.out.println("http请求的数据为 ---->" + httpRequest);

                        if (httpRequest.getRequestURI() == null || "".equals(httpRequest.getRequestURI())) {
                            selectionKey.channel();
                            continue;

                        }
                        System.out.println("...数据解析完毕,准备响应数据....");

                        //响应数据
                        HttpResponse httpResponse = new HttpResponse(selectionKey);
                        httpResponse.setHttpRequest(httpRequest);


                        if(httpRequest.getRequestURI().startsWith("/servlet")){
                            //本次请求动态资源

                            DynamicResourceProcess drp = new DynamicResourceProcess();
                            drp.process(httpRequest,httpResponse);

                        }else{
                            //本次请求静态资源
                            httpResponse.sendStaticResource();
                        }
                    }
                    //任务处理完毕以后,将SelectionKey从集合中移除
                    iterator.remove();
                }
            }
        }
    }
}
