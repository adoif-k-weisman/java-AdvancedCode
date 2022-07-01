package myself.socket.tcpexercise2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10002);
        while (true){
        Socket accept = ss.accept();
        //网络中的流，从客户端读取数据的
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
        //本地的IO流，把数据写到本地中，实现永久化存储
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("socketmodule\\"+
                UUID.randomUUID().toString() +".jpg"));

        int b;
        while ((b=bis.read())!=-1){
            bos.write(b);
        }

        //文件上传完毕 写回完成信号
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));

        bw.write("上传成功");
        bw.newLine();
        bw.flush();

        bos.close();
        accept.close();
        ss.close();//这个socket 都关了，那么网络中的输入输出流都会关了
        }

    }
}
