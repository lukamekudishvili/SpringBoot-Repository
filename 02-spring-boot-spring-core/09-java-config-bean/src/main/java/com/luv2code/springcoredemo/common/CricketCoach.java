package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    public CricketCoach(){
        System.out.println("In Constructor: "+this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return String.join(",",this.getClass().getSimpleName(),"gives us daily workout");
    }
}
