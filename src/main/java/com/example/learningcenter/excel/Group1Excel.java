package com.example.learningcenter.excel;

import com.example.learningcenter.model.Group1;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Group1Excel {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    List<Group1> group1List;

    public Group1Excel(List<Group1> group1) {
        this.group1List = group1;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Group1");
    }


    public void writeHeaderRow() {
        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue("FirstName");

        cell = row.createCell(1);
        cell.setCellValue("LastName");

        cell = row.createCell(2);
        cell.setCellValue("Price");

        cell = row.createCell(3);
        cell.setCellValue("GivePriceDate");

        cell = row.createCell(4);
        cell.setCellValue("ComeDate");

        cell = row.createCell(5);
        cell.setCellValue("PhoneNumber");

        cell = row.createCell(6);
        cell.setCellValue("GroupName");

        cell = row.createCell(7);
        cell.setCellValue("January");

        cell = row.createCell(8);
        cell.setCellValue("February");

        cell = row.createCell(9);
        cell.setCellValue("March");

        cell = row.createCell(10);
        cell.setCellValue("April");

        cell = row.createCell(11);
        cell.setCellValue("May");

        cell = row.createCell(12);
        cell.setCellValue("June");

        cell = row.createCell(13);
        cell.setCellValue("July");

        cell = row.createCell(14);
        cell.setCellValue("Avgust");

        cell = row.createCell(15);
        cell.setCellValue("September");

        cell = row.createCell(16);
        cell.setCellValue("October");

        cell = row.createCell(17);
        cell.setCellValue("November");

        cell = row.createCell(18);
        cell.setCellValue("December");

    }

    public void writeDateRow() {
        int rowCount = 1;
        for (Group1 group1 : group1List) {
            Row row = sheet.createRow(rowCount++);

            Cell cell = row.createCell(0);
            cell.setCellValue(group1.getFirstName());

            cell = row.createCell(1);
            cell.setCellValue(group1.getLastName());

            cell = row.createCell(2);
            cell.setCellValue(group1.getPrice());

            cell = row.createCell(3);
            cell.setCellValue(group1.getGivePriceDate());

            cell = row.createCell(4);
            cell.setCellValue(group1.getComeDate());

            cell = row.createCell(5);
            cell.setCellValue(group1.getPhoneNumber());

            cell = row.createCell(6);
            cell.setCellValue(group1.getGroupName());

            cell = row.createCell(7);
            cell.setCellValue(group1.getJanuary());

            cell = row.createCell(8);
            cell.setCellValue(group1.getFebruary());

            cell = row.createCell(9);
            cell.setCellValue(group1.getMarch());

            cell = row.createCell(10);
            cell.setCellValue(group1.getApril());

            cell = row.createCell(11);
            cell.setCellValue(group1.getMay());

            cell = row.createCell(12);
            cell.setCellValue(group1.getJune());

            cell = row.createCell(13);
            cell.setCellValue(group1.getJuly());

            cell = row.createCell(14);
            cell.setCellValue(group1.getAvgust());

            cell = row.createCell(15);
            cell.setCellValue(group1.getSeptember());

            cell = row.createCell(16);
            cell.setCellValue(group1.getOctober());

            cell = row.createCell(17);
            cell.setCellValue(group1.getNovember());

            cell = row.createCell(18);
            cell.setCellValue(group1.getDecember());


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
