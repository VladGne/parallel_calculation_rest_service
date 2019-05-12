package com.parallelcalculation.restservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Request {
    private String arraySize;
    private String threadsNumber;
}