package com.sourjelly.springtest.jpa.repository;

import com.sourjelly.springtest.jpa.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
