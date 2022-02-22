package cn.jxlg.spark.domain;

/**
 * @program: SparkStreaming_Web
 * @package: cu.just.spark.domain
 * @filename: Point.java
 * @create: 2020/04/12 19:58
 * @author: 29314
 * @description: .
 **/

public class Search {

  private String time;

  public Search() {
  }

  public Search(String time) {
    this.time = time;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }
}
