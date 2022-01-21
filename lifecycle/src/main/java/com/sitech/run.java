package com.sitech;
import org.mybatis.spring.annotation.MapperScan;
	import org.springframework.boot.SpringApplication;
	import org.springframework.boot.autoconfigure.SpringBootApplication;
	import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication(scanBasePackages = "com.sitech")
@MapperScan("com.sitech.**.dao")
public class run {
	
	
	    public static void main(String[] args) {
	        SpringApplication.run(run.class, args);
	    }
	

}
