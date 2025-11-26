package com.sourjelly.springtest.jpa;

import com.sourjelly.springtest.jpa.domain.Company;
import com.sourjelly.springtest.jpa.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/jpa/company")
@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/add")
    @ResponseBody
    public List<Company> addCompany(){

        List<Company> companyList = new ArrayList<>();
        Company company = companyService.createCompany("넥손", "컨텐츠 게임", "대기업", 3585);
        companyList.add(company);

        company = companyService.createCompany("버블팡", "여신 금융업", "대기업", 6834);
        companyList.add(company);


        return companyList;

    }

    @GetMapping("/modify")
    @ResponseBody
    public Company modifyCompany(){

        Company company = companyService.updateCompany(8, 34,"중소기업");

        return company;
    }

    @GetMapping("/remove")
    @ResponseBody
    public String removeCompany(){
        companyService.deleteCompany(9);
        companyService.deleteCompany(10);
        companyService.deleteCompany(11);
        companyService.deleteCompany(12);
        companyService.deleteCompany(13);
        companyService.deleteCompany(14);

        return "삭제 완료";
    }


}
