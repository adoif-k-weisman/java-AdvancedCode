package bytestream.com.itheima.buffer_io;

import java.io.*;

public class BufferOutputArr {
    public static void main(String[] args) throws IOException {
        //缓冲流结合数组，进行文件拷贝

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\IdeaProjects\\AdvancedCode\\IO\\src\\bytestream\\buffer-test.jpg"));

        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("C:\\Users\\adoif\\Documents\\Zapya\\Folder\\49549834_p0.jpg"));
        byte[] bytes=new byte[1024];
        int len;
        while((len=bis.read())!=-1){
            bos.write(bytes,0,len);
        }

        bis.close();
        bos.close();
    }
}
