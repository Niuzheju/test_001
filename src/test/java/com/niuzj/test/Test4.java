package com.niuzj.test;

import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class Test4 {

    /**
     * 导出大excel, 10000行数据
     * 使用SXSSFWorkbook,指定一个行数,当内存中的数据超过这个数字后会把数据写到硬盘的临时文件中,防止内存溢出
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        SXSSFWorkbook workbook = new SXSSFWorkbook(500);
        SXSSFSheet sheet = workbook.createSheet();
        for (int i = 0; i < 10000; i++) {
            SXSSFRow row = sheet.createRow(i);
            for (int j = 0; j < 10; j++) {
                SXSSFCell cell = row.createCell(j);
                String str = new CellReference(cell).formatAsString();
                cell.setCellValue(str);

            }
        }
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.dispose();


    }

}
