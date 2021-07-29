package com.chap2.book.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing 분리됨 -> config 패키지의 JpaConfig
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // 내장된 WAS로 실행
        SpringApplication.run(Application.class, args);
    }
}
