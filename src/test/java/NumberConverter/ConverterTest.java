package NumberConverter;

import NumberConverter.domain.TestData;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ConverterTest {

    @Test
        public void convert(){
            String actual;
            String expected;

            List<TestData> list = new ArrayList<>(new ExcelReader().parse("C://Test.xlsx"));
            for(TestData element : list){
                actual = new Converter().convert(element.getActual());
                expected = element.getExpected();
                Assert.assertEquals(expected,actual);
            }
    }
}