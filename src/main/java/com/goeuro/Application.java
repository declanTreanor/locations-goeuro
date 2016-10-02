package com.goeuro;

import com.goeuro.service.CityInfoParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan({"com.goeuro.service"})
@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) throws Exception {
        validate(args);
        SpringApplication.run(Application.class).getBean(CityInfoParser.class).run(args);
    }

    private static void validate(String[] args) {
        if(args.length != 1){
            log.error("There must be one (and only one) argument!");
            System.exit(-1);
        }
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}