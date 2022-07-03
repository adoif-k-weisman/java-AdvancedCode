package com.itheima.parse;

import com.itheima.httpserver.NotImplementsHttpServletException;
import com.itheima.httpserver.ServletConcurrentHashMap;
import com.itheima.myservlet.HttpServlet;

import java.io.File;
import java.lang.annotation.Annotation;

public class AnnoParseServletConfig implements ParseServletConfig {

    //定义一个servlet路径所对应的常量
    public static final String SERVLET_PATH = "http-dynamic-server\\src\\com\\itheima\\myservlet";

    //定义包名
    public static final String SERVLET_PACKAGE_NAME = "com.itheima.myservlet.";

    @Override
    public void parse() {
        //获取类名
//  1.获得servlet所在文件夹的路径，并封装成File对象
        File file = new File(SERVLET_PATH);
//  2.调用listFiles方法，获取文件夹下所有的File对象
        File[] servletFiles = file.listFiles();
//  3.遍历数组，获取每一个File对象
        for (File servletFile : servletFiles) {
//  4.获取File对象的名字（后缀名）
            String servletFileName = servletFile.getName().replace(".java", "");
//  5.根据包名 + 类名 得到每一个类的全类名
           String servletFullName = SERVLET_PACKAGE_NAME + servletFileName;
            try {
//  6.通过全类名获取字节码文件对象
                Class servletClazz = Class.forName(servletFullName);
                //  7.判断该类是否有WebServlet注解
                if(servletClazz.isAnnotationPresent(WebServlet.class)){
                //  8.判断该Servlet类是否实现HttpServlet接口
                    //获取该类所实现的所有的接口信息,得到的是一个数组
                    Class[] interfaces = servletClazz.getInterfaces();

                    //定义一个boolean类型的变量
                    boolean flag =  false;
                    //遍历数组
                    for (Class clazzInfo : interfaces) {
                        //判断当前所遍历的接口的字节码对象是否和HttpServlet的字节码文件对象相同
                        if(clazzInfo == HttpServlet.class){
                            //如果相同,就需要更改flag值.结束循环
                            flag = true;
                            break;
                        }
                    }

                    if(flag){
                        //  9.如果满足，则获取注解中的urlPattrens的值，
                        WebServlet annotation = (WebServlet) servletClazz.getAnnotation(WebServlet.class);
                        String uri = annotation.urlPatterns();

                        //  10.创建当前Servlet类对象存入值位置
                        HttpServlet httpServlet = (HttpServlet) servletClazz.newInstance();
                        //  11.存入集合的键位置
                        ServletConcurrentHashMap.map.put(uri,httpServlet);
                        //
                    }else{
                        //  12.如果不满足，抛出异常
                        //false就表示当前的类还没有实现HttpServlet接口
                        throw new NotImplementsHttpServletException(servletClazz.getName() + "Not Implements HttpServlet");
                    }
                }
            } catch (NotImplementsHttpServletException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



        }
    }
