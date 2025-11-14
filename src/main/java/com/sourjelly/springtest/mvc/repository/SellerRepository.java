package com.sourjelly.springtest.mvc.repository;

import com.sourjelly.springtest.mvc.domain.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SellerRepository {

    public Seller selectSellerOnRecent();

    public Seller selectIdSeller(@Param("id") int id);

    public int insertSeller(
            @Param("nickname") String nickname
            , @Param("temperature") double temperature
            , @Param("profileImage") String profileImage
    );
}
