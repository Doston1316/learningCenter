package com.example.learningcenter.service.Impl;

import com.example.learningcenter.model.Group1;

import java.util.List;

public interface Group1Service {

    Group1 save(Group1 group1);
    Group1 update(Group1 group1,Long id);
    void delete(Long id);
    Group1 findById(Long id);
    List<Group1>findAll();
    Group1 obnovit(Long id);
    List<Group1>search(String name);

}
