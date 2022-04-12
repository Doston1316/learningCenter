package com.example.learningcenter.excel;

import com.example.learningcenter.model.Group1;
import com.example.learningcenter.model.NewGroup;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class NewGroupExcel {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    List<NewGroup> newGroups;

    public NewGroupExcel(List<NewGroup> newGroups) {
        this.newGroups = newGroups;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("newGroup");
    }


    public void writeHeaderRow() {
        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue("FirstName");

        cell = row.createCell(1);
        cell.setCellValue("LastName");

        cell = row.createCell(2);
        cell.setCellValue("Age");

        cell = row.createCell(3);
        cell.setCellValue("PhoneNumber");

        cell = row.createCell(4);
        cell.setCellValue("PhoneFather");

        cell = row.createCell(5);
        cell.setCellValue("PhoneMother");

        cell = row.createCell(6);
        cell.setCellValue("GroupName");

        cell = row.createCell(7);
        cell.setCellValue("DateStart");

        cell = row.createCell(8);
        cell.setCellValue("CameTime");


    }

    public void writeDateRow() {
        int rowCount = 1;
        for (NewGroup newGroup : newGroups) {
            Row row = sheet.createRow(rowCount++);

            Cell cell = row.createCell(0);
            cell.setCellValue(newGroup.getFirstName());

            cell = row.createCell(1);
            cell.setCellValue(newGroup.getLastName());

            cell = row.createCell(2);
            cell.setCellValue(newGroup.getAge());

            cell = row.createCell(3);
            cell.setCellValue(newGroup.getPhoneNumber());

            cell = row.createCell(4);
            cell.setCellValue(newGroup.getPhoneFather());

            cell = row.createCell(5);
            cell.setCellValue(newGroup.getPhoneMother());

            cell = row.createCell(6);
            cell.setCellValue(newGroup.getGroupName());

            cell = row.createCell(7);
            cell.setCellValue(newGroup.getDateStart());

            cell = row.createCell(8);
            cell.setCellValue(newGroup.getCameTime());

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
