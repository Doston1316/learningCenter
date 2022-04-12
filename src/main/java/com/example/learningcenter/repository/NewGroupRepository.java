package com.example.learningcenter.repository;

import com.example.learningcenter.model.Group1;
import com.example.learningcenter.model.NewGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewGroupRepository extends JpaRepository<NewGroup, Long> {


    @Query("select g from NewGroup as g where g.groupName like %?1%" +
            "or g.cameTime like %?1%" +
            "or g.dateStart like %?1%")
    List<NewGroup> findByName(String name);
}
