package com.example.crypto.controller;


import org.slf4j.Logger;
import com.example.crypto.service.KlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class KlineController {
    @Autowired
    private KlineService service;


    @GetMapping("/loadKline/{symbol}/{startTime}/{endTime}")
    public List<Kline> requestKline(@PathVariable String symbol,
                                           @PathVariable Long startTime,
                                           @PathVariable Long endTime) {

        System.out.println(symbol + " "+startTime +" "+endTime);
        return service.requestKline(symbol, startTime, endTime);
        //
        //symbol=BTCUSDT&interval=1m&startTime=1523577600000&endTime=1523664000000";


    }
    /*
    @GetMapping("/aggregateKline/{symbol}/{startTime}/{interval}")
    public String getNameFromPathVariables(@PathVariable String symbol,
                                           @PathVariable Long startTime,
                                           @PathVariable Long interval) {

        return service.hello(name);


    }*/


}
