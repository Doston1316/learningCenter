package com.example.learningcenter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group1 extends BaseEntity {
    private String firstName;
    private String lastName;
    private Integer price=0;
    private String givePriceDate;
    private String comeDate;
    private String phoneNumber;
    private String groupName;
    private Integer january=0;
    private Integer february=0;
    private Integer march=0;
    private Integer april=0;
    private Integer may=0;
    private Integer june=0;
    private Integer july=0;
    private Integer avgust=0;
    private Integer september=0;
    private Integer october=0;
    private Integer november=0;
    private Integer december=0;



}
