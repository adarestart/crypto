package com.example.crypto.controller;

import lombok.Data;
@Data
public class Kline {

    private String symbol;
    private Long openTime;
    private Double openPrice;
    private Double highPrice;
    private Double lowPrice;
    private Double closePrice;
    private Double volume;
    private Long closeTime;
    private Double quoteAssetVolume;
    private Integer numberOfTrades;
    private Double takerBuyBaseAssetVolume;
    private Double takerBuyQuoteAssetVolume;

    public Kline(){

    }
    public Kline(String symbol, Long openTime, Double openPrice, Double highPrice, Double lowPrice, Double closePrice, Double volume, Long closeTime, Double quoteAssetVolume, Integer numberOfTrades, Double takerBuyBaseAssetVolume, Double takerBuyQuoteAssetVolume){
        // composite key (symbol, start_time)
        this.openTime = openTime;
        this.symbol = symbol;
        this.openPrice = openPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.closePrice = closePrice;
        this.volume = volume;
        this.closeTime = closeTime;
        this.quoteAssetVolume = quoteAssetVolume;
        this.numberOfTrades = numberOfTrades;
        this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
        this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
    }

}