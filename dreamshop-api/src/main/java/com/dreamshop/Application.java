package com.dreamshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author DreamHeng
 * @date 2019/12/1
 */
@SpringBootApplication
//扫描mybatis通用mapper所在的包
@MapperScan(basePackages = "com.dreamshop.mapper")
//默认扫描com.dreamshop  添加扫描工具包
@ComponentScan(basePackages = {"com.dreamshop","org.n3r.idworker"})
//开启定时任务
@EnableScheduling
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
