package com.InventoryManagementSoftware.infrastructure;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.InventoryManagementSoftware.domain.Entities.TblProduct;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelProductListView {

    private List<TblProduct> products;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelProductListView(List<TblProduct> products) {
        this.products = products;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("productList");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(12);
        style.setFont(font);
        createCell(row, 0, "ID", style);
        createCell(row, 1, "manufacturer", style);
        createCell(row, 2, "productName", style);
        createCell(row, 3, "navCode", style);
        createCell(row, 4, "barcode", style);
        createCell(row, 5, "batchExpiry", style);
        createCell(row, 6, "quantity", style);
        createCell(row, 7, "price", style);
        createCell(row, 8, "pipCode", style);
        createCell(row, 9, "vat", style);
        createCell(row, 10, "lastSoldDate", style);

    }

    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {

        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        } else {
            // cell.setCellValue((Boolean) valueOfCell);
        }
        cell.setCellStyle(style);

    }

    private void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(11);
        style.setFont(font);
        for (TblProduct record : products) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, columnCount, style);
            createCell(row, columnCount++, record.getManufacturer(), style);
            createCell(row, columnCount++, record.getProductName(), style);
            createCell(row, columnCount++, record.getNavCode(), style);
            createCell(row, columnCount++, record.getBarcode(), style);
            createCell(row, columnCount++, record.getBatchExpiry(), style);
            createCell(row, columnCount++, record.getQuantity(), style);
            createCell(row, columnCount++, record.getPrice(), style);
            createCell(row, columnCount++, record.getPipCode(), style);
            createCell(row, columnCount++, record.getVat(), style);
            createCell(row, columnCount++, record.getLastSoldDate(), style);
        }
    }

    public void generateExcelFile(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        write();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

}
