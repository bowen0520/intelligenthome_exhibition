package cn.jxlg.spark.controller;

import cn.jxlg.spark.dao.EnvironmentDao;
import cn.jxlg.spark.domain.Environment;
import cn.jxlg.spark.domain.Search;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: SparkStreaming_Web
 * @package: cu.just.spark.controller
 * @filename: EnvironmentStaticApp.java
 * @create: 2020/04/12 19:53
 * @author: 29314
 * @description: .
 **/
@Controller
public class EnvironmentStaticApp {
    @Autowired
    EnvironmentDao environmentDao;

    @RequestMapping("/get_environment")
    @ResponseBody
    public List<Environment> queryEnv() {
        return environmentDao.query(100);
    }

    @RequestMapping("/m-view")
    public String toMain() {
        return "main_view";
    }

    @RequestMapping("/history-page")
    public String getHistoryPage() {
        return "history";
    }

    @RequestMapping("/h-page")
    public String getHistoryTwoPage() {
        return "historytwo";
    }

    @PostMapping("/search")
    @ResponseBody
    public List<Environment> search(@ModelAttribute Search search) {
        String time = search.getTime();
        if ("".equals(search.getTime())) {
            //System.out.println("设置默认参数");
            time = DateFormatUtils.format(System.currentTimeMillis()-40000,"yyyyMMddHHmm");
        }
        return environmentDao.query(time);
    }
    /*public List<Environment> get() {

    }*/
}
