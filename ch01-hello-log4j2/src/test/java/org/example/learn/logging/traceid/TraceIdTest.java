package org.example.learn.logging.traceid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.UUID;

@SpringBootTest
public class TraceIdTest {

    private static final Logger logger = LoggerFactory.getLogger(TraceIdTest.class);

    @Autowired
    private ConfigurableApplicationContext context;

    @BeforeEach
    public void setup() {
        String traceId = UUID.randomUUID().toString().replace("-", "");
        MDC.put("traceId", traceId);
    }

    @Test
    public void test0() {
        ApplicationRunner applicationRunner = context.getBean(ApplicationRunner.class);
        logger.info("applicationRunner: {}", applicationRunner);
    }
}
