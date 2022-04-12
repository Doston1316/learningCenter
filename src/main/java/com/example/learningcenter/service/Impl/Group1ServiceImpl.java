package com.example.learningcenter.service.Impl;

import com.example.learningcenter.model.Group1;
import com.example.learningcenter.repository.Group1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class Group1ServiceImpl implements Group1Service {

    @Autowired
    private  Group1Repository repository;

    @Override
    public Group1 save(Group1 group1) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = sdf.format(cal.getTime());
        group1.setComeDate(strDate);
        return repository.save(group1);
    }

    @Override
    public Group1 update(Group1 group1, Long id) {
        Group1 group = repository.findById(id).get();
        group.setFirstName(group1.getFirstName());
        group.setLastName(group1.getLastName());
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = sdf.format(cal.getTime());
        group.setGivePriceDate(strDate);
        group.setPrice(group1.getPrice());
        group.setPhoneNumber(group1.getPhoneNumber());
        group.setGroupName(group1.getGroupName());
        group.setJanuary(group1.getJanuary());
        group.setFebruary(group1.getFebruary());
        group.setMarch(group1.getMarch());
        group.setApril(group1.getApril());
        group.setMay(group1.getMay());
        group.setJune(group1.getJune());
        group.setJuly(group1.getJuly());
        group.setAvgust(group1.getAvgust());
        group.setSeptember(group1.getSeptember());
        group.setOctober(group1.getOctober());
        group.setNovember(group1.getNovember());
        group.setDecember(group1.getDecember());
        return repository.save(group);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Group1 findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Group1> findAll() {
        return repository.findAll();
    }

    @Override
    public Group1 obnovit(Long id) {
        Group1 group = repository.findById(id).get();
        group.setJanuary(0);
        group.setFebruary(0);
        group.setMarch(0);
        group.setApril(0);
        group.setMay(0);
        group.setJune(0);
        group.setJuly(0);
        group.setAvgust(0);
        group.setSeptember(0);
        group.setOctober(0);
        group.setNovember(0);
        group.setDecember(0);
        return repository.save(group);
    }

    @Override
    public List<Group1> search(String name) {
        if (name != null) {
            return repository.findByNome(name);
        }
        return repository.findAll();
    }
}
