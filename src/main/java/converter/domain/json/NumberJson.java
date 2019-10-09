package converter.domain.json;

import java.util.List;

public class NumberJson {

    private List<DegreeName> degrees;

    public NumberJson(List<DegreeName> degrees) {
        this.degrees = degrees;
    }

    public NumberJson() {
    }

    public List<DegreeName> getDegrees() {
        return degrees;
    }

    public void setDegrees(List<DegreeName> degrees) {
        this.degrees = degrees;
    }

    @Override
    public String toString() {
        return "NumberJson{" +
                "degrees=" + degrees +
                '}';
    }
}
