package com.springbasics.java_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("com.springbasics")
@PropertySource("classpath:application.properties")
public class NoXmlConfig {
    @Bean
    public FortuneService methodWillbeBeanId(){
        return new SadFortuneService();
    }
    
    @Bean
    public Coach thisWillBeBeanId(){
        return new SwimCoach(methodWillbeBeanId());
    }
}
