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
    public String stringResponse(){
        return "<html>\n" +
                "   <head><title>테스트 프로젝트</title></head>\n" +
                "   <body>\n" +
                "       <h1>테스트 프로젝트 완성</h1>\n" +
                "       <h3>해당 프로젝트를 통해서 문제 풀이를 진행 합니다.</h3>\n" +
                "   </body>\n" +
                "</html>";
    }


    @ResponseBody
    @RequestMapping("/lifecycle/test01/2")
    public Map<String, Integer> Test01Response(){

        Map<String, Integer> score = new HashMap<>();
        score.put("국어", 80);
        score.put("수학", 90);
        score.put("영어", 85);

        return score;
    }

}
