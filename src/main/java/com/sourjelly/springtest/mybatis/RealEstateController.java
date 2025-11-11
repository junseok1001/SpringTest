package com.sourjelly.springtest.mybatis;

import com.sourjelly.springtest.mybatis.domain.RealEstate;
import com.sourjelly.springtest.mybatis.service.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("mybatis/real-estate/select")
public class RealEstateController {

    @Autowired
    private RealEstateService realEstateService;

    // id를 받아 정보를 가져오고 response 에 담기
    @ResponseBody
    @RequestMapping("/1")
    public RealEstate test01(@RequestParam("id") int id){

        RealEstate realEstate = realEstateService.getRealEstate(id);
        return realEstate;

    }

    // 기준 월세를 넘겨 받아 결과를 response에 담기
    @ResponseBody
    @RequestMapping("/2")
    public List<RealEstate> test02(@RequestParam("rent") int rent){

        List<RealEstate> realEstateList = realEstateService.getRentPriceResult(rent);
        return realEstateList;
    }

    // 넓이 이상과 가격 이하 데이터를 받고 response에 담기
    @ResponseBody
    @RequestMapping("/3")
    public List<RealEstate> test03(@RequestParam("area")int area,@RequestParam("price") int price){

        List<RealEstate> realEstateList = realEstateService.getConditionSelect(area, price);
        return realEstateList;

    }


}
