package cn.jxlg.spark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
@Controller
public class Test {
	@RequestMapping("/test")
	public String hello() {
		return "test";
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			System.out.println(sc.nextBigDecimal().add(sc.nextBigDecimal()) );
		}
		String s = "asdasd";
		String[] split = s.split("");
		ArrayList<Integer> strs = new ArrayList<Integer>();
		strs.sort((Integer a, Integer b) -> { return a-b;});
		Arrays.sort(split,0,split.length,(String a, String b) -> { return a.compareTo(b);});
		SpringApplication.run(Test.class, args);
	}

}
