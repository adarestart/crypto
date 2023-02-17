package com.example.crypto.controller;

import java.util.List;

import org.apache.ibatis.annotations.*;

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

    @Insert({ "<script>", "insert into kline(symbol, open_time, open_price, high_price, low_price, close_price, volume, close_time, quote_asset_volume, number_of_trades, taker_buy_base_asset_volume, taker_buy_quote_asset_volume)",
            "values ",
            "<foreach collection='klineList' item='dmo' separator=','>",
            "( #{dmo.symbol,jdbcType=VARCHAR}, #{dmo.openTime,jdbcType=BIGINT}, " +
                    "#{dmo.openPrice,jdbcType=DOUBLE}, #{dmo.highPrice,jdbcType=DOUBLE}, "+
                    "#{dmo.lowPrice,jdbcType=DOUBLE}, #{dmo.closePrice,jdbcType=DOUBLE}, "+
                    "#{dmo.volume,jdbcType=DOUBLE}, #{dmo.closeTime,jdbcType=BIGINT}, "+
                    "#{dmo.quoteAssetVolume,jdbcType=DOUBLE}, #{dmo.numberOfTrades,jdbcType=INTEGER}, "+
                    "#{dmo.takerBuyBaseAssetVolume,jdbcType=DOUBLE}, #{dmo.takerBuyQuoteAssetVolume,jdbcType=DOUBLE}) ",
            "</foreach>", "</script>" })
    int insertBatch(@Param("klineList") List<Kline> klineList);

}
