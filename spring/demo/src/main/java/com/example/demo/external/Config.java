package com.example.demo.external;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class Config {
    @Value("${external.service.url}")
    private String url;

    @Bean
    public SomeExternalService someExternalService(){
       return new SomeExternalService(url);
    };
}
