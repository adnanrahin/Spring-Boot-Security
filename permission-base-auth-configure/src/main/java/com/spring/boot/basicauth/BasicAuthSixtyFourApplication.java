package com.spring.boot.basicauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BasicAuthSixtyFourApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicAuthSixtyFourApplication.class, args);
    }

}
