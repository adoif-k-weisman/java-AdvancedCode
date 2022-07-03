package com.itheima.parse;

import com.itheima.httpserver.NotImplementsHttpServletException;
import com.itheima.httpserver.ServletConcurrentHashMap;
import com.itheima.myservlet.HttpServlet;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class XMLParseServletConfig implements ParseServletConfig {
    //定义web.xml文件的路径
    private static final String WEB_XML_PATH = "http-dynamic-server/webapp/WEB-INF/web.xml";

    @Override
    public void parse() {
        try {
            //1.创建一个解析器对象
            SAXReader saxReader = new SAXReader();

            //2.利用解析器把xml文件读取到内存中
            Document document = saxReader.read(new File(WEB_XML_PATH));

            //3.获取根节点元素对象
            Element rootElement = document.getRootElement();

            //创建一个Map集合，用来存储servlet的配置信息
            HashMap<String,String> servletInfoHashMap = new HashMap<>();

            //4.获取根元素对象下所有的servlet元素的对象
            List<Element> servletInfos = rootElement.elements("servlet");

            //5.遍历集合，依次获取到每一个servlet标签对象
            for (Element servletInfo : servletInfos) {
                //servletInfo依次表示每一个servlet标签对象

                //获取到servlet下的servlet-name元素对象，并且获取标签体内容
                String servletName = servletInfo.element("servlet-name").getText();
                //获取到servlet下的servlet-class元素对象，并且获取标签体内容
                String servletClass = servletInfo.element("servlet-class").getText();

                servletInfoHashMap.put(servletName,servletClass);
            }

            //--------------------servlet-mapping--------------------------------------
            //获取到所有的servlet-mapping标签
            List<Element> servletMappingInfos = rootElement.elements("servlet-mapping");
            //遍历集合依次得到每一个servlet-mapping标签
            for (Element servletMappingInfo : servletMappingInfos) {
                //servletMappingInfo依次表示每一个servlet-mapping标签

                //获取servlet-mapping标签标签中的servlet-name标签的标签体内容
                String servletName = servletMappingInfo.element("servlet-name").getText();

                //获取servlet-mapping标签标签中的url-pattern标签的标签体内容
                String urlPattern = servletMappingInfo.element("url-pattern").getText();

                //通过servletName来获取到servlet的全类名
                String servletClassName = servletInfoHashMap.get(servletName);

                //通过反射来创建这个servlet对象
                Class clazz = Class.forName(servletClassName);

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
                    ServletConcurrentHashMap.map.put(urlPattern,httpServlet);
                }else{
                    //false就表示当前的类还没有实现HttpServlet接口
                    throw new NotImplementsHttpServletException(clazz.getName() + "Not Implements HttpServlet");
                }
            }
        } catch (NotImplementsHttpServletException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
