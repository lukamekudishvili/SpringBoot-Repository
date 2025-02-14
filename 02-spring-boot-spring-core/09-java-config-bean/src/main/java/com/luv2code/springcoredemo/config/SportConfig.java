package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    //or
    //    @Bean("aquatic") will use "aquatic in democontroller for qualifier bean"
    public Coach swimCoach(){
        return new SwimCoach();
    }
}