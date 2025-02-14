package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class TrackCoach implements Coach{
    public TrackCoach(){
        System.out.println("In constructor: "+this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return String.join(",",this.getClass().getSimpleName(),"gives us daily workout");
    }
}
