package cn.jxlg.spark.utils;

import org.apache.log4j.Logger;

/**
 * @program: SparkStreaming_Web
 * @package: cu.just.spark.utils
 * @filename: Log4jUtils.java
 * @create: 2020/04/12 18:08
 * @author: 29314
 * @description: .log4j工具类
 **/

public class Log4jUtils {
    private Logger logger;
    private static Log4jUtils instance;
    private Log4jUtils(){
       logger  = Logger.getLogger(Log4jUtils.class);
    }
    public static synchronized Log4jUtils getInstance(){
        if(instance==null){
            instance=new Log4jUtils();
        }
        return instance;
    }

    public void setInfoLog(String msg){
        logger.info(msg);
    }

    public void setErrLog(String msg){
        logger.error(msg);
    }
}
