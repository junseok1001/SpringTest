package com.sourjelly.springtest.ajax.service;



import com.sourjelly.springtest.ajax.domain.Url;
import com.sourjelly.springtest.ajax.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public List<Url> selectUrl(){

        List<Url> urlList = urlRepository.selectUrlTable();

        return urlList;
    }

    public int createUrl(String name, String url){

        int count = urlRepository.insertUrl(name, url);

        return count;

    }

    // url 테이블에서 중복되어 있지 않으면 false 중복되어 있으면 true
    public boolean isDuplicateUrl(String url){

        int count = urlRepository.isDuplicateUrl(url);

        if(count == 0){
            return false;
        }else{
            return true;
        }
    }

    public boolean deleteUrl(int id){

        int count = urlRepository.removeUrl(id);

        if(count== 0){
            // 삭제되지 않음
            return false;
        }else{
            // 삭제 됨
            return true;
        }

    }
}
