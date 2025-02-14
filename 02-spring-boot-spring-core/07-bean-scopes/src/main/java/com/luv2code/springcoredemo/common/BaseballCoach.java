package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
//@Scope("singleton") //that's by default so no need to write
@Scope("prototype")
public class BaseballCoach implements Coach{
    public BaseballCoach(){
        System.out.println("In Constructor: "+this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return String.join(",",this.getClass().getSimpleName(),"gives us daily workout");
    }
}
