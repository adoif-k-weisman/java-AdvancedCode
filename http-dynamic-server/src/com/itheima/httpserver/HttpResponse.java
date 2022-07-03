package com.itheima.httpserver;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HttpResponse {
    private String version; //协议版本
    private String status;  //响应状态码
    private String desc;    //状态码的描述信息
    private SelectionKey selectionKey;
    private String contentType;//MIME类型

    //响应头数据
    private HashMap<String, String> hm = new HashMap<>();

    private HttpRequest httpRequest;  //我们后面要根据请求的数据,来进行一些判断

    //给浏览器响应数据的方法 ---- 浏览器在请求静态资源时,响应数据的方法.
    public void sendStaticResource() {
        //1.给响应行赋值
        this.version = "HTTP/1.1";
        this.status = "200";
        this.desc = "ok";


        //3.给响应头赋值
        //先获取浏览器请求的URI
        String requestURI = this.getHttpRequest().getRequestURI();
        if(requestURI != null){

            File file = new File(WEB_APP_PATH + requestURI);
            //判断这个路径是否存在
            if(!file.exists()){
                this.status = "404";
                this.desc = "NOT FOUNG";
            }

            if("200".equals(this.status)){
                if("/".equals(requestURI)){
                    hm.put("Content-Type", "text/html;charset=UTF-8");
                }else if("/favicon.ico".equals(requestURI)){
                    hm.put("Content-Type", "image/x-icon");
                }else if("/a.txt".equals(requestURI)){
                    hm.put("Content-Type", "text/html;charset=UTF-8");
                }else if("/1.jpg".equals(requestURI)){
                    hm.put("Content-Type", "image/jpeg");
                }else if("/1.png".equals(requestURI)){
                    hm.put("Content-Type", "image/png");
                }
            }else{
                hm.put("Content-Type", "text/html;charset=UTF-8");
            }

        }


        //2.将响应行拼接成一个单独的字符串 // HTTP/1.1 200 ok
        String responseLine = this.version + " " + this.status + " " + this.desc + "\r\n";


        //4.将所有的响应头拼接成一个单独的字符串
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\r\n");
        }

        //5.响应空行
        String emptyLine = "\r\n";

        //6.响应行,响应头,响应空行拼接成一个大字符串
        String responseLineStr = responseLine + sb.toString() + emptyLine;

        try {
            //7.将上面三个写给浏览器
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            ByteBuffer byteBuffer1 = ByteBuffer.wrap(responseLineStr.getBytes());
            socketChannel.write(byteBuffer1);

            //8.单独操作响应体
            //因为在以后响应体不一定是一个字符串
            //有可能是一个文件,所以单独操作
           // String s = "哎哟,妈呀,终于写完了.";
            byte [] bytes = getContent();
            ByteBuffer byteBuffer2 = ByteBuffer.wrap(bytes);
            socketChannel.write(byteBuffer2);

            //9.释放资源
            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //给浏览器响应数据的方法 ---- 浏览器在请求动态资源时,响应数据的方法.
    //content:响应的内容
    public void write(String content){
        //准备响应行数据
        this.version = "HTTP/1.1";
        this.status = "200";
        this.desc = "ok";

        //把响应行拼接在一起
        String responseLine = this.version + " " + this.status + " " + this.desc + "\r\n";

        //准备响应头
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            //entry依次表示每一个键值对对象
            //键 --- 响应头的名称
            //值 --- 响应头的值
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\r\n");
        }

        //处理响应空行
        String emptyLine = "\r\n";

        //拼接响应行,响应头,响应空行
        String result = responseLine + sb.toString() + emptyLine;

        try {
            //给浏览器响应 响应行,响应头,响应空行
            ByteBuffer byteBuffer1 = ByteBuffer.wrap(result.getBytes());
            SocketChannel channel = (SocketChannel) selectionKey.channel();
            channel.write(byteBuffer1);

            //给浏览器响应 响应体
            ByteBuffer byteBuffer2 = ByteBuffer.wrap(content.getBytes());
            channel.write(byteBuffer2);

            //释放资源
            channel.close();


        } catch (IOException e) {
            System.out.println("响应数据失败....");
            e.printStackTrace();
        }


    }

    public static final String WEB_APP_PATH = "http-dynamic-server\\webapp";
    private byte[] getContent() {
        try {
            //1.获取浏览器请求的URI
            String requestURI = this.getHttpRequest().getRequestURI();
            if(requestURI != null){

                if("200".equals(this.status)){
                    //2.判断一下请求的URI,根据不同的URI来响应不同的东西
                    if("/".equals(requestURI)){
                        String s = "哎哟,妈呀,终于写完了.";
                        return s.getBytes();
                    }else/* if("/favicon.ico".equals(requestURI))*/{
                        //获取一个ico文件
                        FileInputStream fis = new FileInputStream(WEB_APP_PATH + requestURI);
                        //把ico文件变成一个字节数组返回
                        return IOUtils.toByteArray(fis);
                    }
                }else{
                    return "访问的资源不存在".getBytes();
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public HttpResponse(SelectionKey selectionKey) {
        this.selectionKey = selectionKey;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentTpye(String contentType) {
        this.contentType = contentType;

        //添加到map集合中
        hm.put("Content-Type",contentType);
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public SelectionKey getSelectionKey() {
        return selectionKey;
    }

    public void setSelectionKey(SelectionKey selectionKey) {
        this.selectionKey = selectionKey;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public HashMap<String, String> getHm() {
        return hm;
    }

    public void setHm(HashMap<String, String> hm) {
        this.hm = hm;
    }

    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public void setHttpRequest(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "version='" + version + '\'' +
                ", status='" + status + '\'' +
                ", desc='" + desc + '\'' +
                ", hm=" + hm +
                ", httpRequest=" + httpRequest +
                '}';
    }
}
