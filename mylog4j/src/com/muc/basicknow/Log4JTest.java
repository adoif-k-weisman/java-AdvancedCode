package com.muc.basicknow;

//import java.util.logging.Logger;  ---- jdk 里面提供了Logger日志记录嘛？

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4JTest {

    //获取log4j的api来获取日志的对象
    //弊端：如果我们以后更换日志的实现类，那么下面的代码就需要跟着改
    //不推荐使用
//    private static final Logger LOGGER = Logger.getLogger(Log4JTest.class);

    //使用slf4j里面的api来获取日志的对象
    //好处：如果以后我们更换日志的实现类，那么下面的代码不需要跟着修改
    //-----推荐使用
    //注意导入的包来自 slf4j 里面
    private static  final Logger LOGGER = LoggerFactory.getLogger(Log4JTest.class);
    public static void main(String[] args) {
        //1. 导入jar包
        //2. 编写配置文件
        //3. 在代码中获取日志的对象
        //4. 按照日志级别设置日志信息

        //四个最为常用级别的日志
        LOGGER.debug("debug级别的日志");
        LOGGER.info("info级别的日志");
        LOGGER.warn("warn级别的日志");
        LOGGER.error("error级别的日志");


    }
}
