package cn.jxlg.spark.domain;

/**
 * @program: SparkStreaming_Web
 * @package: cu.just.spark.domain
 * @filename: Point.java
 * @create: 2020/04/12 19:58
 * @author: 29314
 * @description: .指定数据
 **/

public class Point {
    private String time;
    private String place;
    private String data;

    public Point() {
    }

    public Point(String time, String place, String data) {
        this.time = time;
        this.place = place;
        this.data = data;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Point{" +
                "time=" + time +
                ", place=" + place +
                ", data=" + data +
                '}';
    }
}
