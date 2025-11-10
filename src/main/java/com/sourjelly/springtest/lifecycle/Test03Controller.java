package com.sourjelly.springtest.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test03Controller {

    // html 경로를 통해 html 을 응답에 담는경우 ResponseBody 없음
    @RequestMapping("/lifecycle/test03")
    public String ThymeleafTest(){
            // html 파일 내부 경로
            // src/main/resources/templates 생략
            // .html 생략
        return "/lifecycle/test03";
    }

}
