package NumberConverter.domain;

public class TestData {

    private String expected;
    private String actual;

    public TestData(String expected, String actual) {
        this.expected = expected;
        this.actual = actual;
    }

    public String getExpected() {
        return expected;
    }

    public String getActual() {
        return actual;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "expected='" + expected + '\'' +
                ", actual='" + actual + '\'' +
                '}';
    }
}
