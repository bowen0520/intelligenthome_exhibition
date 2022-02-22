package cn.jxlg.spark.dao;

import cn.jxlg.spark.domain.Environment;
import cn.jxlg.spark.domain.Point;
import cn.jxlg.spark.utils.MysqlUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: SparkStreaming_Web
 * @package: cu.just.spark.dao
 * @filename: EnvironmentDao.java
 * @create: 2020/04/12 15:23
 * @author: 29314
 * @description: .环境数据监dao层
 **/
@Component
public class EnvironmentDao {
    public List<Environment> query(int nums) {
        return MysqlUtils.getInstance().getData(nums);
    }

    public List<Environment> query(String time) {
        return MysqlUtils.getInstance().getData(time,"");
    }
    /*
    public List<Point> query(String time1,String place,String tp){

    }*/
}
