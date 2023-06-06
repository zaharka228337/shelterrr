package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    @Bean
    public MyService myService() {
        return new MyService();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

