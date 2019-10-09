package converter.domain.json;

import java.util.Objects;

public class DegreeName {

    private String value;
    private String nameOne;
    private String nameTwo;
    private String nameFive;

    public DegreeName() {
    }

    public DegreeName(String value, String nameOne, String nameTwo, String nameFive) {
        this.value = value;
        this.nameOne = nameOne;
        this.nameTwo = nameTwo;
        this.nameFive = nameFive;
    }

    public String getValue() {
        return value;
    }

    public String getNameOne() {
        return nameOne;
    }

    public String getNameTwo() {
        return nameTwo;
    }

    public String getNameFive() {
        return nameFive;
    }

    @Override
    public String toString() {
        return "DegreeName{" +
                "value='" + value + '\'' +
                ", nameOne='" + nameOne + '\'' +
                ", nameTwo='" + nameTwo + '\'' +
                ", nameFive='" + nameFive + '\'' +
                '}';
    }

}

