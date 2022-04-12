package com.example.learningcenter.controller;

import com.example.learningcenter.excel.Group1Excel;
import com.example.learningcenter.excel.NewGroupExcel;
import com.example.learningcenter.model.Group1;
import com.example.learningcenter.model.NewGroup;
import com.example.learningcenter.service.Impl.NewGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/api/newGroup")
@RequiredArgsConstructor
public class NewGroupController {

    private final NewGroupService newGroupService;

    @GetMapping("/findAll")
    public List<NewGroup> listAll() {
        return newGroupService.listAll();
    }

    @GetMapping("/{id}")
    public NewGroup findById(@PathVariable("id") Long id) {
        return newGroupService.findById(id);
    }

    @PostMapping("/save")
    public NewGroup save(@RequestBody NewGroup newGroup) {
        return newGroupService.save(newGroup);
    }

    @PutMapping("/update/{id}")
    public NewGroup update(@RequestBody NewGroup newGroup,
                           @PathVariable("id") Long id){
        return newGroupService.update(newGroup,id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")Long id){
        newGroupService.delete(id);
    }

    @GetMapping("/search/{name}")
    public List<NewGroup>search(@PathVariable("name")String name){
        return newGroupService.search(name);
    }

    @GetMapping("/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = " attachement; fileName= NewGroup.xlsx";

        response.setHeader(headerKey, headerValue);
        List<NewGroup> newGroups = newGroupService.listAll();

        NewGroupExcel newGroupExcel = new NewGroupExcel(newGroups);
        newGroupExcel.export(response);


    }


}
