package bytestream.com.itheima.input;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputDemo1 {
    public static void main(String[] args) throws IOException {
        //如果文件存在，那么就不会报错
        //如果文件不存在，那么就直接报错
        FileInputStream fis = new FileInputStream("D:\\IdeaProjects\\AdvancedCode\\IO\\src\\bytestream\\a.txt");
        int read = fis.read();
        //一次读取一个字节，返回值就是本次读取到的那个字节数据
        //也就是字符在码表中对应的那个数字。
        //如果我们想要看到的是字符串数据，那么一定要强转成char   ...这强转格式挺不函数
        System.out.println((char)read);

        //1、文件中多个字节我怎么办
        /*缺陷：无法判断结束
        while(true){
            int i1=fis.read();
            System.out.println(i1);
        }
        */
        int b;
        while ((b=fis.read())!=-1){
            System.out.println((char)b);
        }

        //释放资源
        fis.close();
    }
}
