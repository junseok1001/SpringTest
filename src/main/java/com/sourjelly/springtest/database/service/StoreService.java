package com.sourjelly.springtest.database.service;

import com.sourjelly.springtest.database.domain.Store;
import com.sourjelly.springtest.database.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StoreService {

    // 모든 행 조회 결과를 담아내는곳
    @Autowired
    private StoreRepository storeRepository;

    // 가게정보 리스트 얻어오기
    public List<Store> storeList(){

        //store 테이블 모든행 조회
        List<Store> storeList = storeRepository.selectStoreList();

        return storeList;
    }
}
