package com.springbasics.java_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ComponentScan("com.springbasics")
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
