package com.projectagora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class RealTimeBidderApp {

    private final static Logger LOGGER = Logger.getLogger(RealTimeBidderApp.class.getName());
    public static void main(String[] args) {

        SpringApplication.run(RealTimeBidderApp.class, args);
        LOGGER.info("RealTimeBidderApp has started --");
    }



}
