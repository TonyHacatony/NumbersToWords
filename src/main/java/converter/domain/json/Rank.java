package converter.domain.json;

import java.util.HashMap;
import java.util.Map;

/**
 * This object contains maps for getting data from rank.json file.
 * All maps contains numbers 0-9 and translate for them.
 * <p>
 * For example:
 * "1":"один" ,"2":"два"
 * <p>
 * Different maps needs for different divides:
 * hundreds - "сотни",
 * tens - "десятки",
 * units - "единицы",
 * thousandUnits -"единицы для тысяч",
 * tensAndUnits - "от 10 до 19"
 *
 * @author Eduard
 */

public class Rank {

    private Map<String,String> hundreds = new HashMap<>();
    private Map<String,String> tens = new HashMap<>();
    private Map<String,String> units = new HashMap<>();
    private Map<String,String> thousandUnits = new HashMap<>();
    private Map<String,String> tensAndUnits = new HashMap<>();

    public Rank() {
    }

    public Rank(Map<String, String> hundreds, Map<String, String> tens, Map<String, String> units, Map<String, String> thousandUnits, Map<String, String> tensAndUnits) {
        this.hundreds = hundreds;
        this.tens = tens;
        this.units = units;
        this.thousandUnits = thousandUnits;
        this.tensAndUnits = tensAndUnits;
    }

    public Map<String, String> getHundreds() {
        return hundreds;
    }

    public Map<String, String> getTens() {
        return tens;
    }

    public Map<String, String> getUnits() {
        return units;
    }

    public Map<String, String> getThousandUnits() {
        return thousandUnits;
    }

    public Map<String, String> getTensAndUnits() {
        return tensAndUnits;
    }


    @Override
    public String toString() {
        return "Rank{" +
                "hundreds=" + hundreds +
                ", tens=" + tens +
                ", units=" + units +
                ", thousandUnits=" + thousandUnits +
                ", tensAndUnits=" + tensAndUnits +
                '}';
    }
}
