package com.example.learningcenter.repository;

import com.example.learningcenter.model.Group1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface Group1Repository extends JpaRepository<Group1,Long> {


    @Query("select g from Group1 as g where g.firstName like %?1%" +
            "or g.lastName like %?1%" +
            "or g.groupName like %?1%")
    List<Group1> findByNome(String name);



}
