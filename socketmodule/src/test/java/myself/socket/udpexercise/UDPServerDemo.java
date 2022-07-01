package myself.socket.udpexercise;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServerDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10000);//接收端需要指定端口

        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
            ds.receive(dp);

            byte[] data = dp.getData();
            int length = dp.getLength();
            System.out.println(new String(data,0,length));
        }
        //不停的接受就不会关闭了
        //ds.close();
    }
}
