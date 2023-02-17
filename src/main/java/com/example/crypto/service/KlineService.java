package com.example.crypto.service;

import com.example.crypto.controller.Kline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.system.JavaVersion;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.crypto.controller.KlineMyBatisRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service
public class KlineService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${getURL}")
    private String getURL;

    @Autowired
    private KlineMyBatisRepository klineRepository;

    @Autowired
    @Qualifier("binance")
    private RestTemplate restTemplate;

    public List<Kline> requestKline(String symbol, Long startTime, Long endTime){
        //return "Hello "+ name + " !"; => result to Null-Pointer Exception
        //return String.format("Hello %s student id is %d !",name, studentId);
        try {
            requestKlineByBatch(symbol, startTime, endTime);


        } catch (Exception e) {
            //throw new RuntimeException(e);
        }
        return klineRepository.findAll();

    }
    public void requestKlineByBatch(String symbol, Long startTime, Long endTime){
        //Long counter = 500*60*1000L;

        Long batchSize=500*60*1000L;
        for(Long time = startTime;time<=endTime;time+=batchSize){
            sendGet(symbol, startTime, endTime);
        }
    }
    // process kline for binance
    public void sendGet(String symbol, Long startTime, Long endTime)  {
        //String getURL = "https://www.binance.com/api/v1/klines?symbol=BTCUSDT&interval=1m&startTime=1523577600000&endTime=1523664000000";
        String url = String.format(getURL, symbol, startTime, endTime);
        System.out.println(url);

        ResponseEntity<String[][]> response
                = restTemplate.getForEntity(url, String[][].class);
        System.out.println(response);

        String[][] res = response.getBody();

        List<Kline> klineList = new ArrayList<>();
        for(String[] kline: res){
            //String symbol = "BTCUSDT";
            Long openTime = Long.parseLong(kline[0]);
            Double openPrice = Double.parseDouble(kline[1]);
            Double highPrice = Double.parseDouble(kline[2]);
            Double lowPrice = Double.parseDouble(kline[3]);
            Double closePrice = Double.parseDouble(kline[4]);
            Double volume = Double.parseDouble(kline[5]);
            Long closeTime = Long.parseLong(kline[6]);
            Double quoteAssetVolume = Double.parseDouble(kline[7]);
            Integer numberOfTrades = Integer.parseInt(kline[8]);
            Double takerBuyBaseAssetVolume = Double.parseDouble(kline[9]);
            Double takerBuyQuoteAssetVolume = Double.parseDouble(kline[10]);
            klineList.add(new Kline(symbol, openTime, openPrice, highPrice, lowPrice, closePrice, volume, closeTime, quoteAssetVolume, numberOfTrades, takerBuyBaseAssetVolume, takerBuyQuoteAssetVolume));
            //Kline newKline = new Kline(symbol, openTime, openPrice, highPrice, lowPrice, closePrice, volume, closeTime, quoteAssetVolume, numberOfTrades, takerBuyBaseAssetVolume, takerBuyQuoteAssetVolume);
            //logger.info("Inserting -> {}", klineRepository.insert(new Kline(symbol, openTime, openPrice, highPrice, lowPrice, closePrice, volume, closeTime, quoteAssetVolume, numberOfTrades, takerBuyBaseAssetVolume, takerBuyQuoteAssetVolume)));

        }
        klineRepository.insertBatch(klineList);
    }

}
