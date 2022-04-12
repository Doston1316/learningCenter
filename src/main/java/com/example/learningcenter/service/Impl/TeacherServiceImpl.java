package com.example.learningcenter.service.Impl;

import com.example.learningcenter.model.Teacher;
import com.example.learningcenter.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public List<Teacher> listAll(String name) {
        if (name !=null){
            teacherRepository.findByName(name);
        }
        return teacherRepository.findAll();
    }

    @Override
    public List<Teacher> listAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(Long id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);

    }

    @Override
    public Teacher update(Teacher teacher,Long id) {
        Teacher teacher1=teacherRepository.getById(id);
        teacher1.setFirstName(teacher.getFirstName());
        teacher1.setLastName(teacher.getLastName());
        teacher1.setGroupName(teacher.getGroupName());
        teacher1.setSalary(teacher.getSalary());
        teacher1.setPhoneNumber(teacher.getPhoneNumber());
        return teacherRepository.save(teacher1);
    }
}
