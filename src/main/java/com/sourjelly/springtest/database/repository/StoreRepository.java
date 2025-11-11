package com.sourjelly.springtest.database.repository;


import com.sourjelly.springtest.database.domain.Store;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 인터페이스는 기능의 정의 즉 매소드의 사용법만 정의 하는것
@Mapper
public interface StoreRepository {

    // store 테이블 모든 행 조회
    public List<Store> selectStoreList();
}
