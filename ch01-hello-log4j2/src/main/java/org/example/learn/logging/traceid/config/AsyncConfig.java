package org.example.learn.logging.traceid.config;

import org.example.learn.logging.traceid.constant.TraceIdConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskDecorator;

import java.util.UUID;

@Configuration
public class AsyncConfig {

    private static final Logger logger = LoggerFactory.getLogger(AsyncConfig.class);

    @Bean
    public TaskDecorator traceIdTaskDecorator() {
        return new TaskDecorator() {
            @Override
            public Runnable decorate(Runnable runnable) {
                return new Runnable() {
                    @Override
                    public void run() {
                        String traceId = UUID.randomUUID().toString().replace("-", "");
                        logger.info("create traceId:{}", traceId);
                        MDC.put(TraceIdConstants.KEY_NAME_TRACE_ID, traceId);
                        try {
                            runnable.run();
                        } finally {
                            MDC.remove(TraceIdConstants.KEY_NAME_TRACE_ID);
                            logger.info("remove traceId:{}", traceId);
                        }
                    }
                };
            }
        };
    }
}
