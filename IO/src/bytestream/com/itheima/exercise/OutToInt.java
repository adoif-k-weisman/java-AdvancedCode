package bytestream.com.itheima.exercise;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutToInt {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("C:\\Users\\adoif\\Documents\\Zapya\\Folder\\yande 315304 kamachi_kamachi-ko puella_magi_madoka_magica thighhighs ultimate_madoka weapon wings.jpg");
        FileOutputStream fos=new FileOutputStream("D:\\IdeaProjects\\AdvancedCode\\IO\\src\\bytestream\\test.jpg");

        byte[] bytes=new byte[1024];
        int len;//本次读到的有效字节个数 --- 这次读了几个字节
        //public int read(byte[] b):从输入流读取最多b.length个字节的数据
        //返回的是读入缓冲区的总字节数，也就是实际的读取字节个数

        while((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
            //这里一定是len,不能是b.length,因为拷贝到最后，很可能不足以完全覆盖上一次的数据，装满这个数组，
            // 那么就会有上一次暂留的数据存在，如果全部拷贝，则数据出错。

        }
//实测确实快！
        fis.close();
        fos.close();
    }
}
