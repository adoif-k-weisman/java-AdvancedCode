package myself.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Server {
    public static void main(String[] args) throws IOException {
        //1.打开服务端通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //2.让这个通道绑定一个端口
        serverSocketChannel.bind(new InetSocketAddress(666));
        //3.设置通道为非阻塞
        serverSocketChannel.configureBlocking(false);
        //4.打开一个选择器
        //Selector --- 选择器
        //        SelectionKey --- 绑定通道后返回那个令牌
        //      SelectableChannel --- 可以使用选择器的通道
        Selector selector = Selector.open();
        //5.绑定选择器和服务端通道
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
//        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        while(true){
            System.out.println("11");
            //选择器会监视客户端通道的状态.
            //6.返回值就表示此时有多少个客户端来连接.
            int count = selector.select();
            System.out.println("222");
            if(count != 0){
                System.out.println("有客户端来连接了");
                //7.会遍历所有的服务端通道.看谁准备好了,谁准备好了,就让谁去连接.
                //获取所有服务端通道的令牌,并将它们都放到一个集合中,将集合返回.
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while(iterator.hasNext()){
                    //selectionKey 依次表示每一个服务端通道的令牌
                    SelectionKey selectionKey = iterator.next();
                    if(selectionKey.isAcceptable()){
                        //可以通过令牌来获取到了一个已经就绪的服务端通道
                        ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
                        //客户端的延伸通道
                        SocketChannel socketChannel = ssc.accept();
                        //将客户端延伸通道设置为非阻塞的
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector,SelectionKey.OP_READ);
                        //当客户端来连接的时候,所有的步骤已经全部执行完毕.
                    }else if(selectionKey.isReadable()){
                        //当前通道已经做好了读取的准备(延伸通道)
                        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
                        //socketChannel.read(byteBuffer1);
                        int len;
                        while((len = socketChannel.read(byteBuffer1)) > 0){
                            byteBuffer1.flip();
                            System.out.println(new String(byteBuffer1.array(),0,len));
                            byteBuffer1.clear();
                        }
                        //给客户端的回写数据
                        socketChannel.write(ByteBuffer.wrap("哎哟喂好疼啊!!!".getBytes()));
                        socketChannel.close();
                    }
                    iterator.remove();
                }
            }
        }
    }
}