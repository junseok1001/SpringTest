package com.sourjelly.springtest.mvc;

import com.sourjelly.springtest.mvc.domain.Seller;
import com.sourjelly.springtest.mvc.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/mvc/seller")
@Controller
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping("/add")
    public String addPage(){
        return "mvc/seller/selleradd";
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
    @GetMapping("/search")
    public String sellerInfoPage(@RequestParam(value="id", required=false) Integer id , Model model){

        Seller seller = null;

        if(id == null){
            seller = sellerService.getRencentSellerInfo();
        }else {
            seller = sellerService.getIdSeller(id);
        }

        model.addAttribute("sellerInfo", seller);

        return "/mvc/seller/sellerInfo";
    }



}
