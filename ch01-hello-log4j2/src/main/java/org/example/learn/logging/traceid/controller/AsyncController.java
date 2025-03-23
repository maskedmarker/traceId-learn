package org.example.learn.logging.traceid.controller;

import org.example.learn.logging.traceid.service.SimpleAsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AsyncController {

    private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    private SimpleAsyncService simpleAsyncService;

    @RequestMapping(path = "/async", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String async() {
        logger.info("handling async...");
        simpleAsyncService.doFooInAsync();
        return "handling async";
    }
}
