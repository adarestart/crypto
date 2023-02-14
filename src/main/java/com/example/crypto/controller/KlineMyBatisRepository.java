package com.example.crypto.controller;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
@Mapper
public interface KlineMyBatisRepository {

    @Select("select * from kline")
    public List<Kline> findAll();

    @Select("SELECT * FROM kline WHERE start_time = #{startTime} and symbol = #{symbol}")
    public Kline findById(Long startTime, String symbol);

    @Delete("DELETE FROM kline WHERE start_time = #{startTime} and symbol = #{symbol}")
    public int deleteById(Long startTime, String symbol);

    @Delete("DELETE FROM kline;")
    public int deleteAll();

    @Insert("INSERT INTO kline(symbol, open_time, open_price, high_price, low_price, close_price, volume, close_time, quote_asset_volume, number_of_trades, taker_buy_base_asset_volume, taker_buy_quote_asset_volume) " +
            " VALUES (#{symbol}, #{openTime}, #{openPrice}, #{highPrice}, #{lowPrice}, #{closePrice}, #{volume}, #{closeTime}, #{quoteAssetVolume}, #{numberOfTrades}, #{takerBuyBaseAssetVolume}, #{takerBuyQuoteAssetVolume})")
    public int insert(Kline kline);

    @Update("Update kline set username=#{username}, " +
            " email=#{email} where id=#{id}")
    public int update(Kline kline);
}
