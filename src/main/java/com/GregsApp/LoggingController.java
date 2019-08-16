package com.GregsApp;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {
    final static Logger logger = Logger.getLogger(LoggingController.class);

    @RequestMapping("/logs")
    public String index(){
        logger.trace("A trace message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "Check out the Logs to see the output...";
    }
}
