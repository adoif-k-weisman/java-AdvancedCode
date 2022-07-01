package myself.socket.multhreadpooltcpexercise2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ServerDemo {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(10003);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,//核心线程数量
                10,//线程池总数量
                60,//临时线程空闲时间
                TimeUnit.SECONDS,//临时线程空闲时间的单位
                new ArrayBlockingQueue<>(5), //阻塞队列
                Executors.defaultThreadFactory(), //创建线程的方式
                new ThreadPoolExecutor.AbortPolicy()//任务拒绝策略
        );

        while (true){
        Socket accept = ss.accept();
        ThreadSocket ts = new ThreadSocket(accept);
        pool.submit(ts);
        }
//        ss.close();//这个socket 都关了，那么网络中的输入输出流都会关了
    }
}
