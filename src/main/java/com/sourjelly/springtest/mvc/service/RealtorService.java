package com.sourjelly.springtest.mvc.service;

import com.sourjelly.springtest.mvc.domain.Realtor;
import com.sourjelly.springtest.mvc.repository.RealtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealtorService {

    @Autowired
    private RealtorRepository realtorRepository;
    // realtor 테이블에서 추가하고 싶은행 추가하기
    public int createRealtor(Realtor realtor){
        int count = realtorRepository.createRealtor(realtor);
        return count;
    }
}
