package com.example.learningcenter.service.Impl;

import com.example.learningcenter.model.Group1;
import com.example.learningcenter.model.NewGroup;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NewGroupService {

    List<NewGroup>listAll();
    NewGroup save(NewGroup newGroup);
    NewGroup update(NewGroup newGroup,Long id);
    void delete(Long id);
    NewGroup findById(Long id);
    List<NewGroup>search(String name);


}
