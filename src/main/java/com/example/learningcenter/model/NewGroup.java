package com.example.learningcenter.model;

import lombok.*;

import javax.persistence.Entity;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NewGroup extends BaseEntity{

    private String firstName;
    private String lastName;
    private String age;
    private String phoneNumber;
    private String phoneFather;
    private String phoneMother;
    private String groupName;
    private String dateStart;
    private String cameTime;



}
