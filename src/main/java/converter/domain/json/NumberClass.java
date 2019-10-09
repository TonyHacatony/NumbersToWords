package converter.domain.json;

import java.util.List;

/**
 * @author Eduard
 * This object contains list with degrees.
 *
 * @see converter.domain.json.DegreeName;
 *
 * */

public class NumberClass {

    private List<DegreeName> degrees;

    public NumberClass(List<DegreeName> degrees) {
        this.degrees = degrees;
    }

    public NumberClass() {
    }

    public List<DegreeName> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<DegreeName> degrees) {
        this.degrees = degrees;
    }

    @Override
    public String toString() {
        return "NumberClass{" +
                "degrees=" + degrees +
                '}';
    }
}
