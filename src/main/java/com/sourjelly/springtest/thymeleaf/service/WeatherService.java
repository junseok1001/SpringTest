package com.sourjelly.springtest.thymeleaf.service;

import com.sourjelly.springtest.thymeleaf.domain.Weather;
import com.sourjelly.springtest.thymeleaf.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    // weather 테이블에서 데이터들 가져오기
    public List<Weather> searchTable(){

        List<Weather> weatherList = weatherRepository.selectWeatherTable();

        return weatherList;

    }

}
