package com.vipworld.DatabaseToExcelMailer.service;
import com.vipworld.DatabaseToExcelMailer.entity.Product;
import com.vipworld.DatabaseToExcelMailer.repository.ProductRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;


@Service
public class ExcelService {
    @Autowired
    ProductRepository productRepository;

    public byte[] exportToExcel() throws IOException{
        List<Product> productList = productRepository.findAll();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet  = workbook.createSheet("Data");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Brand");
        headerRow.createCell(3).setCellValue("Code");
        headerRow.createCell(4).setCellValue("Category");
        headerRow.createCell(5).setCellValue("Sub Category");
        headerRow.createCell(6).setCellValue("Sub Category 2");
        headerRow.createCell(7).setCellValue("Description");

        int rowNum = 1;
        for(Product product : productList){
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(product.getId());
            row.createCell(1).setCellValue(product.getName());
            row.createCell(2).setCellValue(product.getBrand());
            row.createCell(3).setCellValue(product.getCode());
            row.createCell(4).setCellValue(product.getCategory());
            row.createCell(5).setCellValue(product.getSubCategory());
            row.createCell(6).setCellValue(product.getSubCategory2());
            row.createCell(7).setCellValue(product.getDescription());
        }
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        return outputStream.toByteArray();
    }
}
