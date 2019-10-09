package converter.domain;

import java.util.Objects;
/**
 * This class consist of hundred, ten and unit of one class number.
 * <p>
 * For example:
 * number (345) -> Digit (hundred-3, ten-4, unit-5)
 * @author Eduard
 * */
public class Digit {

    private String hundred;
    private String ten;
    private String unit;

    public Digit() {
    }

    public Digit(String hundred, String ten, String unit) {
        this.hundred = hundred;
        this.ten = ten;
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Digit{" +
                "hundred='" + hundred + '\'' +
                ", ten='" + ten + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digit digit = (Digit) o;
        return Objects.equals(hundred, digit.hundred) &&
                Objects.equals(ten, digit.ten) &&
                Objects.equals(unit, digit.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hundred, ten, unit);
    }

    public String getHundred() {
        return hundred;
    }

    public String getTen() {
        return ten;
    }

    public String getUnit() {
        return unit;
    }

}
