package com.sourjelly.springtest.mybatis.service;

import com.sourjelly.springtest.mybatis.domain.RealEstate;
import com.sourjelly.springtest.mybatis.repository.RealEstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealEstateService {

    @Autowired
    private RealEstateRepository realEstateRepository;

    public RealEstate getRealEstate(int id){

        // real_estate 테이블에서 id와 일치하는 행 조회
        RealEstate realEstate = realEstateRepository.selectRealEstate(id);
        return realEstate;
    }

    public List<RealEstate> getRentPriceResult(int rent){
        List<RealEstate> realEstateList = realEstateRepository.rentPriceSelect(rent);
        return realEstateList;
    }

    public List<RealEstate> getConditionSelect(int area, int price){

        List<RealEstate> realEstateList = realEstateRepository.conditionSelect(area,price);
        return realEstateList;
    }

    public int createRealEstateByObject(RealEstate realEstate){

        int count = realEstateRepository.insertRealEstateByObject(realEstate);
        return count;
    }

    public int createRealEstateByParameter(
            int realtorId
            , String address
            , int area
            , String type
            , int price
            , int rentPrice){
        int count = realEstateRepository.insertRealEstateByParameter(realtorId, address, area, type, price, rentPrice);
        return count;
    }


    // 값을 전달하여 real_estate 테이블의 행을 변화 시켜 실행한 쿼리 수를 리턴해준다.
    public int updateRealEstate(RealEstate realEstate){

          int count = realEstateRepository.updateRealEstateByObject(realEstate);

          return count;

//        return realEstateRepository.updateRealEstateByObject(realEstate);
    }
}
