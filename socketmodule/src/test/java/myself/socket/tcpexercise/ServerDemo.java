package myself.socket.tcpexercise;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);

        Socket accept = ss.accept();
        InputStream inputStream = accept.getInputStream();
        int b;
        while ((b= inputStream.read())!=-1){
            System.out.print((char) b);
        }
        //针对服务器是往外写的
        /*OutputStream outputStream = accept.getOutputStream();
        outputStream.write("你谁啊".getBytes());*/
        //改成字符流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("你谁啊？");
        bw.newLine();//写一个行分隔符
        bw.flush();

        bw.close();
        inputStream.close();
        accept.close();
        ss.close();

    }
}
