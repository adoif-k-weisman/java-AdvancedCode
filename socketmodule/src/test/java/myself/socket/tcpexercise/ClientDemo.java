package myself.socket.tcpexercise;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10001);
        //对于客户端来说，是往外写的
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello".getBytes());
        //这里，会一直卡住   write缺少结束标记
//        outputStream.close();//如果在这里关流，会导致整个socket都无法使用
        socket.shutdownOutput();//仅仅关闭输出流，并写一个结束标志，对socket没有任何影响

        //接收数据
        /*InputStream inputStream = socket.getInputStream();
        int b;
        while ((b = inputStream.read()) != -1) {
            System.out.println((char) b);
        }*/
        //utf-8 中文占三个字节 需要使用字符流  but socket不提供字符流，那么使用转换流
        //InputStreamReader是从字节流到字符流的桥接器  为了获得最高效率，请考虑在BufferedReader中包装InputStreamReader。
        //缓冲字符输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
        outputStream.close();
        socket.close();

    }
}
