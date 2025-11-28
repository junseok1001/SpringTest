package com.sourjelly.springtest.jpa.repository;

import com.sourjelly.springtest.jpa.domain.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface RecruitRepository extends JpaRepository<Recruit, Integer> {


    public List<Recruit> findByCompanyId(int companyId);

    public List<Recruit> findByPositionAndType(String position, String type);

    public List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int rang1);

    public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);

    public List<Recruit> findByRegionAndSalaryBetween(String region, int range1, int range2);

    @Query(value="" +
            "SELECT * FROM `recruit` WHERE type = :type AND (deadline > :deadline AND salary >= salary) \n" +
            "ORDER BY `salary` DESC", nativeQuery = true)
    public List<Recruit> selectComplex(@Param("type") String type, @Param("deadline")LocalDateTime deadline, @Param("salary") int salary );



}
