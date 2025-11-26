package com.sourjelly.springtest.jpa.service;

import com.sourjelly.springtest.jpa.domain.Company;
import com.sourjelly.springtest.jpa.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    // company에 전달받은값 저장
    public Company createCompany(
            String name
            , String business
            , String scale
            ,  int headcount
    ){
        Company company = Company.builder()
                .name(name)
                .business(business)
                .scale(scale)
                .headcount(headcount)
                .build();
        Company result = companyRepository.save(company);

        return result;
    }


    public Company updateCompany(int id, int headcount, String scale){
        // Jpa 에서 업데이트 할때는,
        // 업데이트 하고 싶은 객체 얻어오기
        // 수정하기
        // 저장하기
        Optional<Company> optionalCompany = companyRepository.findById(id);
//        optionalCompany.isPresent() 가 null 이 아니면 true, null이 면 false

        if(optionalCompany.isPresent()){
            Company company = optionalCompany.get();
            company = company.toBuilder().scale(scale).headcount(headcount).build();

            Company result = companyRepository.save(company);
            return result;
        }else{
            return null;
        }
    }

    public void deleteCompany (int id){

        // 삭제할 대상 테이블 1행의 정보를 가져온다. (id를 통해서(pk을 통해서))
        // 삭제한다 return 은 없다.

        Optional<Company> optionalCompany = companyRepository.findById(id);

        if(optionalCompany.isPresent()){
            // null 이 아니면
            Company company = optionalCompany.get();
            companyRepository.delete(company);
        }
    }






}
