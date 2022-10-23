package com.dev.rabbitmq_producer_web;

import com.dev.rabbitmq_producer_web.utill.StringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqProducerWebApplication {

    public static void main(String[] args) {
        String profile = StringUtil.nvl(System.getProperty("spring.profiles.active"), "local");
        System.setProperty("spring.profiles.active", profile);
        System.setProperty("service.name", "producer_web");

        SpringApplication.run(RabbitmqProducerWebApplication.class, args);
    }

}
