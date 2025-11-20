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
}
