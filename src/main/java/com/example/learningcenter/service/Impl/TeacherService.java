package com.example.learningcenter.service.Impl;

import com.example.learningcenter.model.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher>listAll(String name);
    List<Teacher>listAll();
    Teacher findById(Long id);
    Teacher save(Teacher teacher);
    void delete(Long id);
    Teacher update(Teacher teacher,Long id);



}
