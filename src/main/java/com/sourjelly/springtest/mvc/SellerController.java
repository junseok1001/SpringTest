package com.sourjelly.springtest.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/mvc/seller")
@Controller
public class SellerController {

    @RequestMapping("/add")
    public String insertPage(){

        return "/mvc/seller/selleradd";
    }

    @RequestMapping("/search")
    public String sellerInfoPage(){

        return "/mvc/seller/sellerInfo";
    }

    // 최근에 등록한 정보 response에 담기
    @GetMapping("/result")
    public  searchSeller(){

    }
}
