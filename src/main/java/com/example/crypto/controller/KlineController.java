package com.example.crypto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller {


    @GetMapping("/loadKline/{symbol}/{startTime}/{endTime}")
    public String getNameFromPathVariables(@PathVariable String symbol,
                                           @PathVariable Long startTime,
                                           @PathVariable Long endTime) {

        //return service.hello(name);
        return "";
    
    }
    @GetMapping("/aggregateKline/{symbol}/{startTime}/{interval}")
    public String getNameFromPathVariables(@PathVariable String symbol,
                                           @PathVariable Long startTime,
                                           @PathVariable Long interval) {

        //return service.hello(name);
        return "";

    }


}
