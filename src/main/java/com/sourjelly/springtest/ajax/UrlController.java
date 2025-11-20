package com.sourjelly.springtest.ajax;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ajax/url")
@Controller
public class UrlController {

    // view 만들기 응답으로 html 주소
    @GetMapping("/add")
   public String addUrlPage(){
       return "ajax/url/addurl";
   }

   @GetMapping("/form")
    public String formUrlPage(){
        return "ajax/url/formurl";
   }

   // api 기능 만들곳
    public addUrl(){

    }


}
