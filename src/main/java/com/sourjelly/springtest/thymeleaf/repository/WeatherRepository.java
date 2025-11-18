package com.sourjelly.springtest.thymeleaf.repository;

import com.sourjelly.springtest.thymeleaf.domain.Weather;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WeatherRepository {

    public List<Weather> selectWeatherTable();
}
