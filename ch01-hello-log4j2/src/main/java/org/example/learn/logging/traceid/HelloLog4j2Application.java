package org.example.learn.logging.traceid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class HelloLog4j2Application {

    public static void main(String[] args) {
        SpringApplication.run(HelloLog4j2Application.class);
    }
}
