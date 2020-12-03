package com.yoooum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com/yoooum/dao")
public class AnalyzeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnalyzeApplication.class, args);
    }

}
