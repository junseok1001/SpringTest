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
    //입력받은 값을 처리해서 JSON 문자열로 리턴해주기
    @GetMapping("/Api")
    @ResponseBody
    public Map<String, String> addUrlByparameter(
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

    // 전달받은 주소를 중복되었는지 JSON 문자열로 담기
    @GetMapping("duplicate-url")
    @ResponseBody
    public Map<String, Boolean> isDuplicateUrl(@RequestParam("url") String url){

        Map<String, Boolean> isDuplicate = new HashMap<>();
        if(urlService.isDuplicateUrl(url)){
            // 중복되어 있으면
            // {"result", false}
            isDuplicate.put("result", false);

        }else {
            // 중복되어 있지 않으면
            // {"result", true}
            isDuplicate.put("result", true);
        }

        return isDuplicate;
    }

    // 아이디를 입력받아 삭제성공, 실패를 JSON 문자열에 담기
    @GetMapping("/remove")
    @ResponseBody
    public Map<String, Boolean> removeItem(@RequestParam("id") int id){

        Map<String, Boolean> result = new HashMap<>();
        if(urlService.deleteUrl(id)){
            // 삭제됨
            // {"remove": true}
            result.put("remove", true);
        }else{
            // 삭제 안됨
            // {"remove": false}
            result.put("remove", false);
        }

        return result;
    }




}
