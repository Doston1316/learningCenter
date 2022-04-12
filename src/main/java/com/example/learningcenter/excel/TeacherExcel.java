package com.example.learningcenter.excel;

import com.example.learningcenter.model.Teacher;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TeacherExcel {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    List<Teacher> teachers;

    public TeacherExcel(List<Teacher> teachers) {
        this.teachers = teachers;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("teacher");
    }


    public void writeHeaderRow() {
        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue("FirstName");

        cell = row.createCell(1);
        cell.setCellValue("LastName");

        cell = row.createCell(2);
        cell.setCellValue("GroupName");

        cell = row.createCell(3);
        cell.setCellValue("PhoneNumber");

        cell = row.createCell(4);
        cell.setCellValue("Salary");

    }

    public void writeDateRow() {
        int rowCount = 1;
        for (Teacher teacher : teachers) {
            Row row = sheet.createRow(rowCount++);

            Cell cell = row.createCell(0);
            cell.setCellValue(teacher.getFirstName());

            cell = row.createCell(1);
            cell.setCellValue(teacher.getLastName());

            cell = row.createCell(2);
            cell.setCellValue(teacher.getGroupName());

            cell = row.createCell(3);
            cell.setCellValue(teacher.getPhoneNumber());

            cell = row.createCell(4);
            cell.setCellValue(teacher.getSalary());
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderRow();
        writeDateRow();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

}
