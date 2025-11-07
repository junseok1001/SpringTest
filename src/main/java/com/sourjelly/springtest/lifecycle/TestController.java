package com.sourjelly.springtest.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {


    @ResponseBody
    @RequestMapping("/lifecycle/test01/1")
    public Map<String, Integer> Test01Response(){

        Map<String, Integer> score = new HashMap<>();
        score.put("국어", 80);
        score.put("수학", 90);
        score.put("영어", 85);

        return score;
    }

}
