package com.sourjelly.springtest.thymeleaf;


import com.sourjelly.springtest.thymeleaf.domain.Weather;
import com.sourjelly.springtest.thymeleaf.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequestMapping("/thymeleaf")
@Controller
public class WeatherController {


    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weatherMain")
    public String weatherMain(Model model){

        List<Weather> weatherList = weatherService.selectWeatherHistory();
        model.addAttribute("weatherList", weatherList);


        return "thymeleaf/weather/mainpage";
    }


    @GetMapping("/InputPage")
    public String weatherInputPage(){
        return "thymeleaf/weather/weatherInput";
    }


//   이거 다시 한번 봐보기
    @GetMapping("/weatherInput")
    public String weatherInputFunction(@ModelAttribute Weather weather){


//            @RequestParam("date") @DateTimeFormat(pattern = "yyyy년 M월 d일") LocalDate date // 2025-04-12
//                , @RequestParam(value="weather", required= false) String weather
//                , @RequestParam(value="temperatures", required=false) double temperatures
//                , @RequestParam(value="precipitation", required=false) double precipitation
//                , @RequestParam(value="microDust", required=false) String microDust
//                , @RequestParam(value="windSpeed", required=false) double windSpeed){

//        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));


//        int count = weatherService.insertWeatherByParam(date, weather, temperatures,precipitation, microDust, windSpeed);

        // 리다이렉션 쓰는거

        int count = weatherService.createWeatherByObject(weather);
//        return localDate + " ";
        return "redirect:/thymeleaf/weatherMain";
    }


}
