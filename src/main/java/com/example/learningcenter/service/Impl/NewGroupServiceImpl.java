package com.example.learningcenter.service.Impl;

import com.example.learningcenter.model.NewGroup;
import com.example.learningcenter.repository.NewGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewGroupServiceImpl implements NewGroupService {

    @Autowired
    private NewGroupRepository newGroupRepository;


    @Override
    public List<NewGroup> listAll() {
        return newGroupRepository.findAll();
    }

    @Override
    public NewGroup save(NewGroup newGroup) {
        return newGroupRepository.save(newGroup);
    }

    @Override
    public NewGroup update(NewGroup newGroup, Long id) {
        NewGroup newGroupD = newGroupRepository.getById(id);
        newGroupD.setFirstName(newGroup.getFirstName());
        newGroupD.setLastName(newGroup.getLastName());
        newGroupD.setGroupName(newGroup.getGroupName());
        newGroupD.setAge(newGroup.getAge());
        newGroupD.setCameTime(newGroup.getCameTime());
        newGroupD.setPhoneFather(newGroup.getPhoneFather());
        newGroupD.setPhoneMother(newGroup.getPhoneMother());
        newGroupD.setPhoneNumber(newGroup.getPhoneNumber());
        newGroupD.setDateStart(newGroup.getDateStart());
        return newGroupRepository.save(newGroupD);
    }

    @Override
    public void delete(Long id) {
        newGroupRepository.deleteById(id);
    }

    @Override
    public NewGroup findById(Long id) {
        return newGroupRepository.findById(id).get();
    }

    @Override
    public List<NewGroup> search(String name) {
        if (name !=null){
            newGroupRepository.findByName(name);
        }
        return newGroupRepository.findAll();
    }
}
