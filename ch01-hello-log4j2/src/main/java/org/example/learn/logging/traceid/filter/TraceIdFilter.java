package org.example.learn.logging.traceid.filter;

import org.example.learn.logging.traceid.constant.TraceIdConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.UUID;

public class TraceIdFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(TraceIdFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String traceId = UUID.randomUUID().toString().replace("-", "");
        logger.info("create traceId:{}", traceId);
        MDC.put(TraceIdConstants.KEY_NAME_TRACE_ID, traceId);
        chain.doFilter(request, response);
        MDC.remove(TraceIdConstants.KEY_NAME_TRACE_ID);
        logger.info("remove traceId:{}", traceId);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
