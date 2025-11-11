package com.sourjelly.springtest.database;

import com.sourjelly.springtest.database.domain.Store;
import com.sourjelly.springtest.database.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StoreController {

    @Autowired
    private StoreRepository storeRepository;

    //목적 store 의 정보들을 response 에 담기
    @ResponseBody
    @RequestMapping("/db/store/list")
    public List<Store> storeList(){

        // 가게 정보 리스트 얻어오기 (얻어오는 과정은 controller 역활이 아님.)
        List<Store> storeList = storeRepository.selectStoreList();
        return storeList;

    }

}
