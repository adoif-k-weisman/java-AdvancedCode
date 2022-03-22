package bytestream.com.itheima.buffer_io;

import java.io.*;

public class BufferOutAndIn {
    public static void main(String[] args) throws IOException {
        //利用缓冲流去拷贝文件

        //创建一个字节缓冲输入流
        //在底层创建了一个默认长度为8192的字节数组
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\IdeaProjects\\AdvancedCode\\IO\\src\\bytestream\\buffer-test.jpg"));
        //创建一个字节缓冲输出流
        //在底层也创建了一个默认长度为8192的字节数组
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("C:\\Users\\adoif\\Documents\\Zapya\\Folder\\49549834_p0.jpg"));
        int b;
        while((b=bis.read())!=-1){
            bos.write(b);
        }
        //方法的底层会把字节流关闭。
        bis.close();
        bos.close();
    }
}
