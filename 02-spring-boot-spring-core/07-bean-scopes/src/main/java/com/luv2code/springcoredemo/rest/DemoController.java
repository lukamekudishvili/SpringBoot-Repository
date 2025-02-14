package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    private Coach myAnotherCoach;

    @Autowired
    public DemoController(@Qualifier("baseballCoach") Coach myCoach, @Qualifier("baseballCoach") Coach myAnotherCoach){
        System.out.println("In constructor: "+this.getClass().getSimpleName());
        this.myCoach=myCoach;
        this.myAnotherCoach=myAnotherCoach;
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String checkObjects(){
        return "Checking: "+(this.myCoach==this.myAnotherCoach); //true until our bean scope is singleton
    }
}
