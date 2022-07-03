package com.itheima.httpserver;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;

/**
 * 用来封装请求数据的类
 */
public class HttpRequest {
    private String method; //请求方式
    private String requestURI; //请求的uri
    private String version;   //http的协议版本
    private SelectionKey selectionKey;

    private HashMap<String,String> hm = new HashMap<>();//所有的请求头

    //用来存储请求URL中问号后面的那些数据
    //id=1  name=itheima
    private Map<String,String> paramterHashMap = new HashMap<>();



    //parse --- 获取请求数据 并解析
    public void parse(){
        try {
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

            StringBuilder sb = new StringBuilder();
            //创建一个缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int len;
            //循环读取
            while((len = socketChannel.read(byteBuffer)) > 0){
                byteBuffer.flip();
                sb.append(new String(byteBuffer.array(),0,len));
                //System.out.println(new String(byteBuffer.array(),0,len));
                byteBuffer.clear();
            }
            //System.out.println(sb);
            parseHttpRequest(sb);


            //解析请求参数，把请求参数存储到paramterHashMap集合
            parseParamter();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //解析请求参数，把请求参数存储到paramterHashMap集合
    private void parseParamter(){

        //获取请求的uri
        String requestURI = this.requestURI;

        //按照问号进行切割，然后再获取到第二部分
        String[] uriInfoArr = requestURI.split("\\?");

        //判断数组的长度，如果长度为2，说明是存在请求参数。
        if(uriInfoArr.length == 2){
            //获取请求参数内容（问号后面的那些参数）
            String paramterInfo = uriInfoArr[1];

            //使用&进行切割
            String[] paramterInfoArr = paramterInfo.split("&");

            //遍历数组
            //id=1 name=itheima age =23
            for (String paramter : paramterInfoArr) {
                String[] paramterArr = paramter.split("=");

                //获取请求参数名称
                String paramterName = paramterArr[0];

                //获取请求参数的值
                String paramterValue = paramterArr[1];

                //添加到集合中
                paramterHashMap.put(paramterName,paramterValue);

            }


        }
    }


    //id=1 name=itheima
    //可以根据请求参数的名称来获取请求参数的值
    public String getParamter(String name){
        return paramterHashMap.get(name);
    }

    //解析http请求协议中的数据
    private void parseHttpRequest(StringBuilder sb) {
        //1.需要把StringBuilder先变成一个字符串
        String httpRequestStr = sb.toString();
        if(!(httpRequestStr == null || "".equals(httpRequestStr))){
            //2.获取每一行数据
            String[] split = httpRequestStr.split("\r\n");
            //3.获取请求行
            String httpRequestLine = split[0];//GET / HTTP/1.1
            //4.按照空格进行切割,得到请求行中的三部分
            String[] httpRequestInfo = httpRequestLine.split(" ");
            this.method = httpRequestInfo[0];
            this.requestURI = httpRequestInfo[1];
            this.version = httpRequestInfo[2];
            //5.操作每一个请求头
            for (int i = 1; i < split.length; i++) {
                String httpRequestHeaderInfo = split[i];//Host: 127.0.0.1:10000
                String[] httpRequestHeaderInfoArr = httpRequestHeaderInfo.split(": ");
                hm.put(httpRequestHeaderInfoArr[0],httpRequestHeaderInfoArr[1]);
            }
        }
    }

    public HttpRequest(SelectionKey selectionKey) {
        this.selectionKey = selectionKey;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public HashMap<String, String> getHm() {
        return hm;
    }

    public void setHm(HashMap<String, String> hm) {
        this.hm = hm;
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", requestURI='" + requestURI + '\'' +
                ", version='" + version + '\'' +
                ", hm=" + hm +
                '}';
    }
}
