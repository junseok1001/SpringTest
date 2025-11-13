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
@RequestMapping("mybatis/real-estate")
public class RealEstateController {

    @Autowired
    private RealEstateService realEstateService;

    // id를 받아 정보를 가져오고 response 에 담기
    @ResponseBody
    @RequestMapping("/select/1")
    public RealEstate test01(@RequestParam("id") int id){

        RealEstate realEstate = realEstateService.getRealEstate(id);
        return realEstate;

    }

    // 기준 월세를 넘겨 받아 결과를 response에 담기
    @ResponseBody
    @RequestMapping("/select/2")
    public List<RealEstate> test02(@RequestParam("rent") int rent){

        List<RealEstate> realEstateList = realEstateService.getRentPriceResult(rent);
        return realEstateList;
    }

    // 넓이 이상과 가격 이하 데이터를 받고 response에 담기
    @ResponseBody
    @RequestMapping("/select/3")
    public List<RealEstate> test03(
            @RequestParam("area") int area
            , @RequestParam("price") int price){

        List<RealEstate> realEstateList = realEstateService.getConditionSelect(area, price);
        return realEstateList;

    }

    // request 로 받은 값을 response 에 담기
    @ResponseBody
    @RequestMapping("/insert/1")
    public String insertTest01(){
        RealEstate realEstate = new RealEstate();
        realEstate.setRealtorId(3);
        realEstate.setAddress("푸르지용 리버 303동 1104호");
        realEstate.setArea(89);
        realEstate.setType("매매");
        realEstate.setPrice(100000);

        int count = realEstateService.createRealEstateByObject(realEstate);
        return "입력 성공 : " + count;

    }

    // 파마리터로 전달받은값에 해당 내용 넣고 결과 알려주기
    @ResponseBody
    @RequestMapping("/insert/2")
    public String insertTest02(@RequestParam("realtorId") int realtorId){
        String address = "썅떼빌리버 오피스텔 814호";
        int area = 45;
        String type = "월세";
        int price = 100000;
        int rentPrice = 120;

        int count = realEstateService.createRealEstateByParameter(realtorId, address, area, type, price, rentPrice);
        return "입력 성공 : " +count;
    }


    // 요청받은 id의 데이터를 수정하여 결과를 response 에 담기
    @ResponseBody
    @RequestMapping("/update/1")
    public String updateTest01(@RequestParam("id") int id){
        RealEstate realEstate = new RealEstate();

        realEstate.setId(id);
        realEstate.setType("전세");
        realEstate.setPrice(70000);

        int count = realEstateService.updateRealEstate(realEstate);
        return "수정 성공 : " + count;
    }

    // 브라우저로 부터 받은 id의 데이터를 삭제하여 삭제 결과를 response에 담아 보여주기
    //
    @ResponseBody
    @RequestMapping("/delete/1")
    public String deleteTest01(@RequestParam("id") int id){
        RealEstate realEstate = new RealEstate();

        realEstate.setId(id);

        int count = realEstateService.deleteRealEstate(realEstate);

        return "삭제 성공 : " + count;
    }

}
