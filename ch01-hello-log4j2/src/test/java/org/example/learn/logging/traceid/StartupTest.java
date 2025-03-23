package org.example.learn.logging.traceid;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootTest
public class StartupTest {

    private static final Logger logger = LoggerFactory.getLogger(StartupTest.class);

    @Autowired
    private ConfigurableApplicationContext context;

    @Test
    public void test0() {
        ApplicationRunner applicationRunner = context.getBean(ApplicationRunner.class);
        logger.info("applicationRunner: {}", applicationRunner);
    }
}
