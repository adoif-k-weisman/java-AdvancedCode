package myself.socket.multicastudp;

import java.io.IOException;
import java.net.*;

public class MClientDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        String s = "hello 组播";
        byte[] bytes = s.getBytes();
        //使用组播地址 ，之前是IP地址
        InetAddress address = InetAddress.getByName("224.0.1.0");
        int port= 10000;
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length,address,port);

        ds.send(dp);

        ds.close();

    }
}
