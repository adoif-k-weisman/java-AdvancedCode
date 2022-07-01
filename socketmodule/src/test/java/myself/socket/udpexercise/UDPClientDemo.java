package myself.socket.udpexercise;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPClientDemo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        DatagramSocket ds = new DatagramSocket();
        while (true){
            String s = sc.nextLine();
            if("886".equals(s)){
                break;
            }
            byte[] bytes = s.getBytes();
            InetAddress address = InetAddress.getByName("127.0.0.1");//指定发送主机
            int port = 10000;//指定发送主机的指定的端口号
            DatagramPacket dp  =new DatagramPacket(bytes,bytes.length,address,port);

            ds.send(dp);
        }
        ds.close();

    }
}
