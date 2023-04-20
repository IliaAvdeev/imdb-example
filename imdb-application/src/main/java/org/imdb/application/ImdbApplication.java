package org.imdb.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan({"org.imdb.impl","org.imdb.web","org.imdb.model"})
@EnableJpaRepositories({"org.imdb.impl","org.imdb.web","org.imdb.model"})
@EntityScan(basePackages={"org.imdb.impl","org.imdb.web","org.imdb.model"})
@EnableTransactionManagement

@SpringBootApplication(scanBasePackages = {"org.imdb.impl","org.imdb.web","org.imdb.model"})
public class ImdbApplication {
    public static void main(String[] args) {
        SpringApplication.run(ImdbApplication.class, args);
    }
}