package com.ilabservice.intelab;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.retry.annotation.EnableRetry;

/**
 * Created by zyclincoln on 8/10/17.
 */
@SpringBootApplication
@EnableConfigurationProperties
@EnableRetry
public class Application {

    public static void main(String[] args) throws Throwable {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    }
}