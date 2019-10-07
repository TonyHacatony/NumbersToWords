package NumberConverter;

import NumberConverter.domain.TestData;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {

    public List<TestData> parse(String name) {

        List<TestData> result = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook();

        try(InputStream input = new FileInputStream(name)){
            workbook = new XSSFWorkbook(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
