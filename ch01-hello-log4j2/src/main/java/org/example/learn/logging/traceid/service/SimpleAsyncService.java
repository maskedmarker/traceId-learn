package org.example.learn.logging.traceid.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SimpleAsyncService {

    public static final Logger logger = LoggerFactory.getLogger(SimpleAsyncService.class);

    @Async
    public void doFooInAsync() {
        logger.info("doFoo in async");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
