package com.parallelcalculation.restservice.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class RequestController {

    @RequestMapping("/calculations")
    public String request(@RequestParam(value="arraySize" ) String arraySize,
                   @RequestParam(value="threadsNumber") String threadsNumber){

        return Controller.getCalculationResult(arraySize, threadsNumber);
    }

    @RequestMapping("/calc")
    public String request1(){

        return Controller.getCalculationResult("400000000", "8");
    }
}
