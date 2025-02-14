package com.luv2code.springcoredemo.common;


public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In constructor: "+this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return String.join(",",this.getClass().getSimpleName(),"gives us daily workout");
    }
}
