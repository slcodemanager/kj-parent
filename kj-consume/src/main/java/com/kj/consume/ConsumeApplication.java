package com.kj.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author quan
 * @date 2021-01-18 11:46
 */
@SpringBootApplication
@MapperScan({"com.kj.consume.mapper"})
public class ConsumeApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumeApplication.class, args);
    }
}
