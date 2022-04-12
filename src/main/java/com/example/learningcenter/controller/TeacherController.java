package com.example.learningcenter.controller;

import com.example.learningcenter.excel.NewGroupExcel;
import com.example.learningcenter.excel.TeacherExcel;
import com.example.learningcenter.model.Teacher;
import com.example.learningcenter.service.Impl.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;


    @GetMapping("/{name}")
    public List<Teacher>list(@PathVariable("name")String name){
        return teacherService.listAll(name);
    }

    @PostMapping("/save")
    public Teacher save(@RequestBody Teacher teacher){
        return teacherService.save(teacher);
    }

    @PutMapping("/update/{id}")
    public Teacher update(@RequestBody Teacher teacher,
                          @PathVariable("id") Long id){
        return teacherService.update(teacher,id);
    }

    @GetMapping("/{id}")
    public Teacher findById(@PathVariable("id")Long id){
        return teacherService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Long id){
        teacherService.delete(id);
    }

    @GetMapping("/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = " attachement; fileName= Teacher.xlsx";

        response.setHeader(headerKey, headerValue);
        List<Teacher> teachers = teacherService.listAll();

        TeacherExcel teacherExcel = new TeacherExcel(teachers);
        teacherExcel.export(response);


    }


}
