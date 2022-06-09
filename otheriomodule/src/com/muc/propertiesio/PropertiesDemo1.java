package com.muc.propertiesio;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

//map集合
public class PropertiesDemo1 {
    public static void main(String[] args) {
        //method1();


    //Properties的特有方法
        //Object setProperty(String key, String value) --- put
        //设置集合的键和值，都是String类型，底层调用 Hashtable方法 put
        Properties prop = new Properties();
        prop.setProperty("江苏","南京");
        prop.setProperty("安徽","南京");
        prop.setProperty("山东","济南");

        System.out.println(prop);
        //String getProperty(String key)  --- get
        //使用此属性列表中指定的键搜索属性

       /* String value = prop.getProperty("江苏");
        System.out.println(value);*/


        //Set<String> stringPropertyNames()  --- keySet
        //从该属性列表中返回一个不可修改的键集，其中键及其对应的值是字符串

        Set<String> keys = prop.stringPropertyNames();
        for (String key : keys) {
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }

    }

    private static void method1() {
        //创建对象
        Properties properties = new Properties();

        //增 key---value
        properties.put("aaa","AAA");
        properties.put("bbb","BBB");
        properties.put("ccc","CCC");

        //删  通过key 下指定删除元素
        properties.remove("bbb");
        //改
        //put --- 如果键不存在，就添加；如果键存在，就覆盖
        properties.put("aaa","shiina");
        //查
        // 通过key 查找value
        Object val = properties.get("aaa");

        //遍历
        //获得所有的键去遍历
        Set<Object> keys = properties.keySet();
        for (Object key : keys) {
            Object val_ = properties.get(key);
            System.out.println(key + "=" + val_);
        }
        //获得所有的键值对对象遍历
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> objectEntry : entries) {
            Object key1 = objectEntry.getKey();
            Object value = objectEntry.getValue();
            System.out.println(key1+"="+value);
        }
    }
}
