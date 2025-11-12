package com.sourjelly.springtest.mybatis.repository;

import com.sourjelly.springtest.mybatis.domain.RealEstate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RealEstateRepository {

    // select 쿼리로 id 값을 입력받아 하나의 행을 가져와야징
    public RealEstate selectRealEstate(@Param("id") int id);

    //
    public List<RealEstate> rentPriceSelect(@Param("rent") int rent);

    //
    public List<RealEstate> conditionSelect(
            @Param("area") int area
            , @Param("price") int price);

    public int insertRealEstateByObject(RealEstate realEstate);

    public int insertRealEstateByParameter(
            @Param("realtorId")int realtorId
            ,@Param("address") String address
            ,@Param("area") int area
            ,@Param("type") String type
            ,@Param("price") int price
            ,@Param("rentPrice") int rentPrice
            );

    public int updateRealEstateByObject(RealEstate realEstate);

    public int deleteRealEstateByObject(RealEstate realEstate);
}
