package com.sourjelly.springtest.mvc.repository;


import com.sourjelly.springtest.mvc.domain.Realtor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RealtorRepository {

    public int createRealtor(Realtor realtor);

}
