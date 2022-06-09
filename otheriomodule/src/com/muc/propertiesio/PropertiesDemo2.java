package com.muc.propertiesio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;


//Properties 继承于 Hashtable。表示一个持久的属性集，属性列表以key-value的形式存在，key和value都是字符串。
public class PropertiesDemo2 {
    public static void main(String[] args) throws IOException {
        //void load(Reader reader)                     将本地文件中的键值对数据读取到集合中
        //void store(Writer writer, String comments)   将集合中的数据以键值对形式保存在本地


        //loadMethod();
        Properties prop = new Properties();
        prop.put("adoif","123");
        prop.put("shina","456");
        prop.put("paperqueen","789");

        FileWriter fw = new FileWriter("otheriomodule\\prop.properties");
        prop.store(fw,"这是注释语句");
        //prop.store(fw,null);

        fw.close();

    }

    private static void loadMethod() throws IOException {
        //读取
        Properties prop = new Properties();
        FileReader fr = new FileReader("otheriomodule\\prop.properties");
        //调用完了load方法之后,文件中的键值对数据已经在集合中了.
        prop.load(fr);
        fr.close();

        System.out.println(prop);
    }
}
