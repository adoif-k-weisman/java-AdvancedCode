package bytestream.com.itheima.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputDemo2 {
    public static void main(String[] args) throws IOException {
        //第二个参数就是续写开关，如果没有传递，默认就是false，
        //表示不打开续写功能，那么创建对象的这行代码会清空文件

        //如果第二个参数为true，表示打开续写功能
        //那么创建对象的这行代码不会清空文件。

        //在文件中进行追加操作 既然是追加操作，就不能对不存在的文件进行追加写入
        FileOutputStream fos =new FileOutputStream("D:\\OutputStream.txt",true);

        fos.write(97);
        fos.write("\r\n".getBytes());
        fos.close();
    }
}
