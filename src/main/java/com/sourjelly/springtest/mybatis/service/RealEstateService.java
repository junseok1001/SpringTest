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
}
