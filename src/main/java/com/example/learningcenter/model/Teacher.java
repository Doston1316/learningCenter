package com.example.learningcenter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher extends BaseEntity{

    private String firstName;
    private String lastName;
    private String groupName;
    private String phoneNumber;
    private String salary;



}
