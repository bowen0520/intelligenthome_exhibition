package cn.jxlg.spark.domain;

/**
 * @program: SparkStreaming_Web
 * @package: cu.just.spark.domain
 * @filename: Environment.java
 * @create: 2020/04/12 14:43
 * @author: 29314
 * @description: .环境实体类
 **/

public class Environment {
    private String time;
    private String place;
    private String temp;
    private String hum;
    private String co2;
    private String light;

    public Environment() {
    }

    public Environment(String time, String place, String temp, String hum, String co2, String light) {
        this.time = time;
        this.place = place;
        this.temp = temp;
        this.hum = hum;
        this.co2 = co2;
        this.light = light;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHum() {
        return hum;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public String getCo2() {
        return co2;
    }

    public void setCo2(String co2) {
        this.co2 = co2;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    @Override
    public String toString() {
        return "Environment[" +
                "time=" + time +
                ", place=" + place +
                ", temp=" + temp +
                ", hum=" + hum +
                ", co2=" + co2 +
                ", light=" + light +
                ']';
    }
}
