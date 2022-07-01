package myself.socket.multhreadpooltcpexercise2;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",10003);

        //是本地的流，用来读取本地文件的
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("socketmodule\\04.jpg"));

        //写到服务器---网络中的流
        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);

        int b;
        while ((b= bis.read())!=-1){
            bos.write(b);//通过网络写到服务器中
        }

        //给服务器一个结束标志，告诉服务器文件已经传输完毕
        socket.shutdownOutput();


        //读取服务器传递数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }
        bis.close();
        socket.close();
    }

}
