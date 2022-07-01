package myself.socket.threadtcpexercise2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10003);
        while (true){
        Socket accept = ss.accept();
        ThreadSocket ts = new ThreadSocket(accept);
        new Thread(ts).start();
        }
//        ss.close();//这个socket 都关了，那么网络中的输入输出流都会关了
    }
}
