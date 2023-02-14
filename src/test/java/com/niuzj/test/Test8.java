package com.niuzj.test;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

public class Test8 {

    private int memoryValue = 1;

    @Test
    public void test01() throws IOException {
        String path = "e:\\customers.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        Set<String> customers = new LinkedHashSet<>(16);
        String line = null;

        while ((line = bufferedReader.readLine()) != null){
            if (!line.startsWith("CJ")){
                continue;
            }
            customers.add(line);
        }
        bufferedReader.close();
        System.out.println(customers.size());
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        int row = 0;
        for (String customer : customers) {
            HSSFRow sheetRow = sheet.createRow(row++);
            sheetRow.createCell(0).setCellValue(customer);
        }
        File newFile = new File("e:\\1.xls");
        if (newFile.exists()){
            newFile.delete();
        }
        workbook.write(newFile);
        workbook.close();
    }

    /**
     * cas逻辑
     * 从内存中取出值expect
     * 进行计算得到newValue
     * 当且仅当内存中的值等于expect时把newValue设置到内存中
     * 如果不相等，重新从内存中取值，重新计算并设置
     * 同时cas又称为轻量级锁, 自旋锁
     */
    @Test
    public void casTest(){
        int expect = this.getValue();
        int newValue = expect + 1;
        boolean b = cas(newValue, expect);
        System.out.println(b);
        while (!cas(newValue, expect)){
            expect = this.getValue();
            newValue = expect + 1;
        }
    }

    private boolean cas(int newValue, int expect) {
        int memoryValue = getValue();
        if (memoryValue == expect){
            this.memoryValue = newValue;
            return true;
        }
        return false;

    }

    private int getValue(){
        return this.memoryValue;
    }
}
