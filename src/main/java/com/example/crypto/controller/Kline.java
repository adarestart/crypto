package com.example.crypto.controller;

import lombok.Data;
@Data
public class Kline {
    private Long openTime;
    private String symbol;

    private Double openPrice;
    private Double highPrice;
    private String lowPrice;
    private String closePrice;
    private String volume;
    private Long closeTime;
    private String quoteAssetVolume;
    private Integer numberOfTrades;
    private String takerBuyBaseAssetVolume;
    private String takerBuyQuoteAssetVolume;

    public Kline(){

    }
    public Kline(String symbol, Long startTime, String openPrice, String highPrice, String lowPrice, String closePrice, String volume, Long closeTime, String quoteAssetVolume, Integer numberOfTrades, String takerBuyBaseAssetVolume, String takerBuyQuoteAssetVolume){
        // composite key (symbol, start_time)
        //
        this.startTime = startTime;
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