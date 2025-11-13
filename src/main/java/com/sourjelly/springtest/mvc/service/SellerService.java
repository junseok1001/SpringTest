package com.sourjelly.springtest.mvc.service;


import com.sourjelly.springtest.mvc.domain.Seller;
import com.sourjelly.springtest.mvc.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;
    //seller테이블에서 최근에 등록한 정보 가져오기
    public Seller getRencentSellerInfo(){
        Seller seller = sellerRepository.selectSellerOnRecent();

        return seller;
    }

    public Seller getIdSeller(int id){
        Seller seller = sellerRepository.selectIdSeller(id);

        return seller;
    }

    public int createSeller(
             String nickname
            , double temperature
            , String profileImage
    ){

        int count = sellerRepository.createSeller(nickname, temperature, profileImage);

        return count;

    }
}
