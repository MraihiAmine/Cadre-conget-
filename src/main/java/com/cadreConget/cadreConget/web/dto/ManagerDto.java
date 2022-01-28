package com.cadreConget.cadreConget.web.dto;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data

@Entity
public class ManagerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int age;
    private String name;
    private String email;
}
