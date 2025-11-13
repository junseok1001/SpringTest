package com.sourjelly.springtest.mvc.repository;

import com.sourjelly.springtest.mvc.domain.Seller;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SellerRepository {

    public Seller selectSellerOnRecent();
}
