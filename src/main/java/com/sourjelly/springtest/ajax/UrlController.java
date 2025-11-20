package com.sourjelly.springtest.ajax;


import com.sourjelly.springtest.ajax.domain.Url;
import com.sourjelly.springtest.ajax.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/ajax/url")
@Controller
public class UrlController {

    @Autowired
    private UrlService urlService;

    // view 만들기 응답으로 html 주소
    @GetMapping("/add")
   public String addUrlPage(){
       return "ajax/url/addurl";
   }

   @GetMapping("/form")
    public String formUrlPage(Model model){
       List<Url> urlList = urlService.selectUrl();

       model.addAttribute("urlList", urlList);

        return "ajax/url/formurl";

   }

//    api 기능 만들곳
    @GetMapping("/Api")
    @ResponseBody
    public Map<String, String> addUrl(
            @RequestParam("name") String name
            , @RequestParam("url") String url
    ){
        int count = urlService.createUrl(name, url);

        // 입력 성공 {"result" : "success"}
        // 입력 실패 {"result" : "fail"}
        Map<String, String> resultMap = new HashMap<>();
        if(count == 1){
            resultMap.put("result", "success");
        }else{
            resultMap.put("result", "fail");
        }

        return resultMap;
    }




}
