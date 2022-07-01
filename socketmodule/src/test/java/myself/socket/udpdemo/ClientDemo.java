package myself.socket.udpdemo;

import java.io.IOException;
import java.net.*;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //1. 找码头
        DatagramSocket ds = new DatagramSocket();
        //2. 打包礼物  数据
        //DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port)
        String s = "adoif love shiina mashiro";
        byte[] bytes = s.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");//本机端口
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);
        //3. 由码头发送包裹
        ds.send(dp);
        //4. 付钱走人
        ds.close();
    }
}
