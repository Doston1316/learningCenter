package com.example.learningcenter.controller;

import com.example.learningcenter.excel.Group1Excel;
import com.example.learningcenter.model.Group1;
import com.example.learningcenter.service.Impl.Group1ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequestMapping("/api/group1")
@RestController
@RequiredArgsConstructor
public class Group1Controller {

    private final Group1ServiceImpl group1Service;


    @GetMapping
    public List<Group1> list() {
        return group1Service.findAll();
    }


    @PostMapping("/save")
    public Group1 save(@RequestBody Group1 group1) {
        return group1Service.save(group1);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        group1Service.delete(id);
    }

    @GetMapping("/{id}")
    public Group1 findById(@PathVariable("id") Long id) {
        return group1Service.findById(id);
    }

    @PutMapping("/update/{id}")
    public Group1 update(@RequestBody Group1 group1,
                         @PathVariable("id") Long id) {
        return group1Service.update(group1, id);
    }

    @GetMapping("/obnovit/{id}")
    public Group1 obnovit(@PathVariable("id") Long id) {
        return group1Service.obnovit(id);
    }

    @GetMapping("/search/{name}")
    public List<Group1> group1List(@PathVariable("name") String name) {
        return group1Service.search(name);
    }

    @GetMapping("/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = " attachement; fileName= Group1.xlsx";

        response.setHeader(headerKey, headerValue);
        List<Group1> group1List = group1Service.findAll();

        Group1Excel group1Excel = new Group1Excel(group1List);
        group1Excel.export(response);


    }
}