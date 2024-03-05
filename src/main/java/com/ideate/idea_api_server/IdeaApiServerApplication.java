package com.ideate.idea_api_server;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan
@Slf4j
public class IdeaApiServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(IdeaApiServerApplication.class, args);
        log.info("hello@@@@@@@@@");
    }

}
