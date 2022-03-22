package bytestream.com.itheima.output;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputDemo3 {
    public static void main(String[] args) {

        //字节流---try catch 捕获异常
        FileOutputStream fos=null;
        try {
           // System.out.println(2/0);
            fos = new FileOutputStream("out\\a.txt");
            fos.write(97);
            fos.write("niumaniuma".getBytes());
            fos.write("\r\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //finally里的代码一定会被执行
            if(fos!=null) {//可能出现其它异常，导致你的fos仍为空
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //以上使用try,catch 捕获异常的标准代码
    }
}
