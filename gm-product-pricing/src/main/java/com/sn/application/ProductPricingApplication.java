package com.sn.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.sn")
@EnableJpaRepositories("com.sn")
@EntityScan("com.sn")
public class ProductPricingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductPricingApplication.class, args);
    }
}
