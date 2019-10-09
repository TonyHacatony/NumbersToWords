package converter;

import converter.domain.TestData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class read and parse excel file for DDT
 * @author Eduard
 * */

public class ExcelReader {

    List<TestData> parseExcel(String name) throws Exception {
        List<TestData> result = new ArrayList<>();
        String file = this.getClass().getClassLoader().getResource(name).getFile();
        InputStream input = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(input);

        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();

        while(rows.hasNext()){
            Row row = rows.next();
            Iterator<Cell> cells = row.iterator();

            while (cells.hasNext()){
                Cell cell = cells.next();
                String actual = cell.getStringCellValue();
                cell = cells.next();
                String expected = cell.getStringCellValue();
                result.add(new TestData(expected,actual));
            }
        }

        return result;
    }
}
