package com.dima.springsecuritystudying;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringSecurityStudyingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityStudyingApplication.class, args);
    }

}
