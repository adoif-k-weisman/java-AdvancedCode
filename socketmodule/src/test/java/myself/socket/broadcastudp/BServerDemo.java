package myself.socket.broadcastudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

//与单播接收端一样
public class BServerDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10000);
        //接收的数组  接收的长度
        DatagramPacket dp = new DatagramPacket(new byte[1024],1024);

        ds.receive(dp);
        byte[] data = dp.getData();
        int length = dp.getLength();
        System.out.println(new String(data,0,length));
        //释放资源
        ds.close();
    }
}
