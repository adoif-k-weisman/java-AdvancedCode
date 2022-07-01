package myself.socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        //1. 创建一个Socket对象
        Socket socket = new Socket("127.0.0.1",10000);

        //2. 获取一个IO流开始写数据
        //这是一个字节流  客户端是往外写---> 所以是Output
        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes());
        //释放资源
        os.close();
        socket.close();
    }
}
