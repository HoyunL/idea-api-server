package com.ideate.idea_api_server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@Slf4j
public class IdeaApiServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(IdeaApiServerApplication.class, args);
        log.info("스프링 실행 완료");
    }

}
