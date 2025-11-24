package com.sourjelly.springtest.ajax.repository;


import com.sourjelly.springtest.ajax.domain.Booking;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PensionRepository {

    // 전체 행조회
    public List<Booking> selectAllInfo();

    // id 가 같은 정보 삭제
    public int deleteBooking(@Param("id") int id);

    // 정보를 db에 저장
    public int insertBooking(Booking booking);

    public Booking selectBooking(
            @Param("name") String name
            ,@Param("phoneNumber") String phoneNumber);


}
