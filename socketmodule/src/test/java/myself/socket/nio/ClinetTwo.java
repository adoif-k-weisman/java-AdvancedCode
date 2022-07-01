package myself.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClinetTwo {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();//打开

        socketChannel.connect(new InetSocketAddress("127.0.0.1",666));

        ByteBuffer byteBuffer1 = ByteBuffer.wrap("吃俺老孙一棒棒TWO".getBytes());
        socketChannel.write(byteBuffer1);//将缓冲器中的数据写入SocketChannel

        System.out.println("数据已经写给服务器TWO");
        //将SocketCjannel中的数据存放到缓冲器
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);
        int len;
        while((len = socketChannel.read(byteBuffer2)) != -1){
            System.out.println("客户端接收回写数据TWO");
            byteBuffer2.flip();//从写模式转换为读模式
            System.out.println(new String(byteBuffer2.array(),0,len));
            byteBuffer2.clear();
        }
        socketChannel.close();
    }
}