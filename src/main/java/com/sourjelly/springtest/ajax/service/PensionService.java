package com.sourjelly.springtest.ajax.service;

import com.sourjelly.springtest.ajax.domain.Booking;
import com.sourjelly.springtest.ajax.repository.PensionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PensionService {

    @Autowired
    private PensionRepository pensionRepository;


    // 전체 정보 가져오기
    public List<Booking> selectPermissInfo(){

        List<Booking> permissList =  pensionRepository.selectAllInfo();

        return permissList;
    }

    // id를 입력받아 그 id정보를 삭제
    public boolean deleteBooking(int id){

        int count = pensionRepository.deleteBooking(id);

        //삭제 되었으면 true
        // 삭제 안되었으면 false
        return count != 0;
    }

    // 데이터베이스에 해당 정보들을 넣는 서비스
    public int insertBooking(Booking booking){


    }


}
