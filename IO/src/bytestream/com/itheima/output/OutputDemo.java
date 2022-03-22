package bytestream.com.itheima.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class OutputDemo {
    public static void main(String[] args) throws IOException {
        //1.创建字节输出流的对象  --- 告诉虚拟机我要往哪个文件写数据了
            //注意点：
            //如果文件不存在，会帮我们自动创建出来
            //如果文件存在，会把文件清空。
//        FileOutputStream fos = new FileOutputStream("D:\\OutputStream.txt");
        //如果不加盘符，就是相对路径，该目录的文件
        FileOutputStream fos = new FileOutputStream(new File("D:\\OutputStream.txt"));

        //2.写数据     传递一个整数时，那么实际上写到文件中的，是这个整数在码表中对应的那个字符
        //一次只能写一个字节数据
        fos.write(99);
        //一次写一个字节数组的
        byte[] b={99,98,87,86};
        fos.write(b);
        //一次写一个字节数组的部分
        byte[] bytes={1,2,34,5,5,6,7,8,9};
        fos.write(bytes,4,4);//off:索引位置

        //如何写入换行呢？Windows下换行符是'\r\n' 但是不支持写入字符串，需要把字符串改成字节流
        String endline = new String("\r\n");
        byte[] endlineBytes = endline.getBytes();
        //fos.write(endlineBytes);
        fos.write("\r\n".getBytes());  //这样简洁一点
        fos.write("already start with new line ".getBytes());
        //3.释放资源
        fos.close();//告诉操作系统，我现在已经不要再用这个文件了。
        //alt+shift+方向键  --- 上下移动
    }
}
