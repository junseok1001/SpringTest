package com.sourjelly.springtest.jpa;

import com.sourjelly.springtest.jpa.domain.Recruit;
import com.sourjelly.springtest.jpa.repository.RecruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@RequestMapping("/jpa/recruit")
@Controller
public class RecruitController {


    // 편의상 서비스는 제외
    @Autowired
    private RecruitRepository recruitRepository;

    // 조회 문제 1번 id로 회사 찾기
    @GetMapping("/searchById")
    @ResponseBody
    public Recruit searchById(){

        Optional<Recruit> optionalRecruit = recruitRepository.findById(8);


        if(optionalRecruit.isPresent()){
            Recruit Recruit = optionalRecruit.get();

            return Recruit;
        }else{
            return null;
        }
    }

    // 조회 2번문제 파라미터로 전달받은 값 검색하여 출력
    @GetMapping("/searchByCompanyId")
    @ResponseBody
    public List<Recruit> searchByCompanyId(@RequestParam("companyId") int companyId){

        List<Recruit> recruitList = recruitRepository.findByCompanyId(companyId);

        return recruitList;
    }


    // 조회 3번문제
    @GetMapping("/searchBoth")
    @ResponseBody
    public List<Recruit> searchByBoth(){

        List<Recruit> recruitList = recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
        return recruitList;
    }

    // 조회 4번문제
    @GetMapping("/searchEach")
    @ResponseBody
    public List<Recruit> searchByEach() {

        List<Recruit> recruitList = recruitRepository.findByTypeOrSalaryGreaterThan("정규직", 9000);

        return recruitList;
    }

    // 조회 문제 5번
    @GetMapping("/searchOrderBy")
    @ResponseBody
    public List<Recruit> searchOrderBy(){


        List<Recruit> recruitList = recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");

        return recruitList;
    }


    // 조회 문제 6번
    @GetMapping("/searchBetween")
    @ResponseBody
    public List<Recruit> searchBetween(){

        List<Recruit> recruitList = recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);

        return recruitList;
    }


    //조회문제 7번
//    @GetMapping("/searchQuery")
//    @ResponseBody
//    public List<Recruit> searchQuery()  {
//
//    }

}
