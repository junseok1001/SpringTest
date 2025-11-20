package com.sourjelly.springtest.ajax.repository;

import com.sourjelly.springtest.ajax.domain.Url;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UrlRepository {

    public List<Url> selectUrlTable();

    public int insertUrl(
             @Param("name") String name
            ,@Param("url") String url);


}
