package com.sourjelly.springtest.mvc;

import com.sourjelly.springtest.mvc.domain.Seller;
import com.sourjelly.springtest.mvc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/mvc/seller")
@Controller
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping("/add")
    public String addPage(){
        return "/mvc/seller/selleradd";
    }

    @ResponseBody
    @PostMapping("/addPage")
    public String insertSeller(
            @RequestParam("nickname") String nickname
            , @RequestParam(value="temperature", required=false) double temperature
            , @RequestParam(value="profileImage", required = false) String profileImage

    ){

        int count = sellerService.createSeller(nickname, temperature, profileImage);

        return "수행 완료 : " + count;
    }

    // 최근에 등록한 정보 response에 담기
    @RequestMapping("/search")
    public String sellerInfoPage(@RequestParam(value="id", required=false) String idString , Model model){

        int id = 0;
        if(idString != null){
            id = Integer.parseInt(idString);
        }

        if(id == 0){
            Seller seller = sellerService.getRencentSellerInfo();

            model.addAttribute("sellerInfo", seller);
        }else {
            Seller seller = sellerService.getIdSeller(id);

            model.addAttribute("sellerInfo", seller);
        }

        return "/mvc/seller/sellerInfo";
    }



}
