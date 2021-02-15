package com.spring.boot.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DatabaseAuthenticationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseAuthenticationApplication.class, args);
    }

}
