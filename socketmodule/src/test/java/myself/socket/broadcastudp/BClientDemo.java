package myself.socket.broadcastudp;

import java.io.IOException;
import java.net.*;

public class BClientDemo {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        String s = new String("广播 hello!");
        byte[] bytes = s.getBytes();
        InetAddress address=InetAddress.getByName("255.255.255.255");
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length,address,port);
        ds.send(dp);

        ds.close();

    }
}
