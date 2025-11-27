package com.sourjelly.springtest.jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name="`recruit`")
public class Recruit {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int companyId;
    private String position;
    private String responsibilities;
    private String qualification;
    private String type;
    private int salary;
    private String region;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime deadline;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
