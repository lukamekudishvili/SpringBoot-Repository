package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class BaseballCoach implements Coach{
    public BaseballCoach(){
        System.out.println("In Constructor: "+this.getClass().getSimpleName());
    }



    @Override
    public String getDailyWorkout(){
        return String.join(",",this.getClass().getSimpleName(),"gives us daily workout");
    }
}
