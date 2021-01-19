package com.kj.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.kj.user.mapper")
public class KjUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(KjUserApplication.class, args);
    }

}
