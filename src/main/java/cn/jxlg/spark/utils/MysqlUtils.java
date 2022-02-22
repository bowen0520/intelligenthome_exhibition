package cn.jxlg.spark.utils;

import cn.jxlg.spark.domain.Environment;
import net.sf.json.JSONArray;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: SparkStreaming_Web
 * @package: cu.just.spark.utils
 * @filename: MysqlUtils.java
 * @create: 2020/04/12 17:38
 * @author: 29314
 * @description: .mysql工具类
 **/

public class MysqlUtils {

    private Connection conn;

    private static MysqlUtils instance=null;

    private MysqlUtils(){
        //获取链接
        String url="jdbc:mysql://192.168.112.135:8017/bs?characterEncoding=utf-8&useSSL=true&serverTimezone=GMT";
        String user="root";
        String passwd="root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,passwd);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized MysqlUtils getInstance(){
        if(instance==null){
            instance=new MysqlUtils();
        }
        return instance;
    }


    public List<Environment> getData(String time,String place){
        List<Environment> envs = new ArrayList<>();
        String where = "";
        if(time != null && time.trim().length()!=0) {
            where = "where time like '" + time + "%' ";
        }
        if(place != null && place.trim().length()!=0) {
            where = "where place = '" + place + "' ";
        }
        if((time != null && time.trim().length()!=0) && (place != null && place.trim().length()!=0)) {
            where = "where time like '" + time + "%' and place = '" + place + "' ";
        }
        String slct = "select * from intelligenthome " + where + "order by time desc ";
        System.out.println(slct);
        Statement statement = null;
        try {
            //获取Statement
            statement = conn.createStatement();
            //执行sql语句
            ResultSet resultSet = statement.executeQuery(slct);
            String t1 = "21.47";
            String t2 = "54.31";
            String t3 = "598";
            String t4 = "203";
            //处理结果集
            while (resultSet.next()) {
                //如果字段有别名，需要使用别名来获取
                String times = resultSet.getString("time");
                String places = resultSet.getString("place");
                String temp = resultSet.getString("temple");
                String hum = resultSet.getString("hum");
                String co2 = resultSet.getString("co2");
                String light = resultSet.getString("light");

                temp = temp != null?temp:t1;
                t1 = temp;
                hum = hum != null?hum:t2;
                t2 = hum;
                co2 = co2 != null?co2:t3;
                t3 = co2;
                light = light != null?light:t4;
                t4 = light;
                String tms = times.substring(8,10)+":"+ times.substring(10,12)+":"+times.substring(12,14);
                Environment env = new Environment(tms,places,temp,hum,co2,light);
                envs.add(0,env);
                Log4jUtils.getInstance().setInfoLog("获取数据："+env.toString());
                //System.out.println(env.toString());
            }
        }catch (SQLException e){
            Log4jUtils.getInstance().setErrLog(e.getMessage());
        }finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if(envs.size()>1000){
            envs.subList(0,1001);
        }
        return envs;
    }

    public List<Environment> getData(int nums){
        List<Environment> envs = new ArrayList<>();
        String slct = "select * from intelligenthome order by time desc limit 0,"+nums;
        Statement statement = null;
        try {
            //获取Statement
            statement = conn.createStatement();
            //执行sql语句
            ResultSet resultSet = statement.executeQuery(slct);
            String t1 = "21.47";
            String t2 = "54.31";
            String t3 = "598";
            String t4 = "203";
            //处理结果集
            while (resultSet.next()) {
                //如果字段有别名，需要使用别名来获取
                String time = resultSet.getString("time");
                String place = resultSet.getString("place");
                String temp = resultSet.getString("temple");
                String hum = resultSet.getString("hum");
                String co2 = resultSet.getString("co2");
                String light = resultSet.getString("light");

                temp = temp != null?temp:t1;
                t1 = temp;
                hum = hum != null?hum:t2;
                t2 = hum;
                co2 = co2 != null?co2:t3;
                t3 = co2;
                light = light != null?light:t4;
                t4 = light;
                String tm = time.substring(8,10)+":"+ time.substring(10,12)+":"+time.substring(12,14);
                Environment env = new Environment(tm,place,temp,hum,co2,light);
                envs.add(0,env);
                Log4jUtils.getInstance().setInfoLog("获取数据："+env.toString());
                //System.out.println(env.toString());
            }
        }catch (SQLException e){
            Log4jUtils.getInstance().setErrLog(e.getMessage());
        }finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return envs;
    }

    public static void main(String[] args) {
        //20200412173642
        //MysqlUtils.getInstance().getData(50).toString();


        MysqlUtils.getInstance().getData("","100").toString();
    }
}
