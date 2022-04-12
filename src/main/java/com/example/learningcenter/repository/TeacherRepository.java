package com.example.learningcenter.repository;

import com.example.learningcenter.model.NewGroup;
import com.example.learningcenter.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {

    @Query("select g from Teacher as g where g.lastName like %?1%" +
            "or g.firstName like %?1%")
    List<NewGroup> findByName(String name);
}
