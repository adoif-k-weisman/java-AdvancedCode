package com.itheima.parse;

import com.itheima.httpserver.NotImplementsHttpServletException;
import com.itheima.httpserver.ServletConcurrentHashMap;
import com.itheima.myservlet.HttpServlet;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesParseServletConfig implements ParseServletConfig {
    @Override
    public void parse() {

        try {
            //1.读取配置文件中的数据
            Properties properties = new Properties();
            FileReader fr = new FileReader("http-dynamic-server/webapp/config/servlet-info.properties");
            properties.load(fr);
            fr.close();

            //2.获取集合中servlet-info的属性值
            String properValue = (String) properties.get("servlet-info");
            // uri,全类名;uri,全类名

            //3.解析
            String[] split = properValue.split(";");
            for (String servletInfo : split) {
                String[] servletInfoArr = servletInfo.split(",");
                String uri = servletInfoArr[0];
                String servletName = servletInfoArr[1];

                //我们需要通过servletName(全类名)来创建他的对象
                Class clazz = Class.forName(servletName);

                //获取该类所实现的所有的接口信息,得到的是一个数组
                Class[] interfaces = clazz.getInterfaces();

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
                    //true就表示当前的类已经实现了HttpServlet接口
                    HttpServlet httpServlet = (HttpServlet) clazz.newInstance();
                    //4.将uri和httpServlet添加到map集合中
                    ServletConcurrentHashMap.map.put(uri,httpServlet);
                }else{
                    //false就表示当前的类还没有实现HttpServlet接口
                    throw new NotImplementsHttpServletException(clazz.getName() + "Not Implements HttpServlet");
                }
            }
        } catch (NotImplementsHttpServletException e) {
            e.printStackTrace();
        }catch (Exception e) {
            System.out.println("解析数据异常.....");
            e.printStackTrace();
        }
    }
}
