package com.itheima.httpserver;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 接收连接的任务处理类
 */
public class AcceptHandler {

    public SocketChannel connSocketChannel(SelectionKey selectionKey){
        try {
            //获取到已经就绪的服务端通道
            ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
            SocketChannel socketChannel = ssc.accept();

            //设置为非阻塞状态
            socketChannel.configureBlocking(false);

            //把socketChannel注册到选择器上
            socketChannel.register(selectionKey.selector(), SelectionKey.OP_READ);

            return socketChannel;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
