package com.sourjelly.springtest.thymeleaf.repository;

import com.sourjelly.springtest.thymeleaf.domain.Weather;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WeatherRepository {

    public List<Weather> selectWeatherTable();

    public int insertWeatherTable(
            @Param("date") String date
            , @Param("weather") String weather
            , @Param("temperatures") double temperatures
            , @Param("precipitation") double precipitation
            , @Param("microDust") String microDust
            , @Param("windSpeed") double windSpeed
    );
}
