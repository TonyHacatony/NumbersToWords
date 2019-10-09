package converter;

import converter.domain.Digit;
import converter.domain.json.NumberClass;
import converter.domain.json.Rank;

import java.util.ArrayList;
import java.util.List;


/**
 * Current class transform number into words. For transform you need two file in package "java/resources/static/"
 * numberclass.json and ranks.json.
 * <p>
 * Пример:
 * Number (1 653) transform in "Одна тысяча шестьсот пятьдесят три".
 * <p>
 * @author Eduard
 * @see converter.domain.json.Rank
 * @see converter.domain.json.NumberClass
* */

public class Converter {
    private List<Digit> digitsList = new ArrayList<>();
    private Rank rank = new Rank();
    private NumberClass numberClasses = new NumberClass();
    private int currentClass = 0;

    public String convert(String number){
        StringBuilder builder = new StringBuilder();
        digitsList.addAll(numberToList(number));
        try {
            rank = new JsonReader().getJsonRanks();
            numberClasses = new JsonReader().getJsonNumbers();
        }catch (Exception e){
            System.out.println("В resources не были найдены файлы для преобразования чисел");
            return "";
        }
        currentClass = digitsList.size()-1;

        if(currentClass==0 && digitsList.get(0).equals(new Digit("0","0","0"))) return "ноль";

        for(Digit element : digitsList){
            builder.append(
                    hundreds(
                            element.getHundred()));
            builder.append(
                    tens(
                            element.getTen(),
                            element.getUnit()));
            builder.append(
                    units(
                            numberClasses.getDegrees().get(currentClass).getNameOne(),
                            element.getTen(),
                            element.getUnit()));

            if(!element.getUnit().equals("0") ||
            !element.getTen().equals("0") ||
            !element.getHundred().equals("0"))
            builder.append(
                    classes(
                            element));
            currentClass--;
        }

        return builder.toString().replaceAll("\\s+"," ").trim();
    }

    /**
     * This method converting number of unit from Digit to word.
     * @see Digit
     * */
    private String units(String currentClass, String ten, String unit){
        String result = "";
        if(ten.equals("1")) return result;
        if(currentClass.equals("тысяча")) {
            result = rank.getThousandUnits().get(unit) + " ";
        }else{
            result = rank.getUnits().get(unit) + " ";
        }
        return result;
    }

    /**
     * This method converting number of tens from Digit to word.
     * @see Digit
     * */
    private String tens(String ten,String unit){
        String result;
        if(ten.equals("1")){
            result = rank.getTensAndUnits().get(unit) + " ";
        }else{
            result = rank.getTens().get(ten) + " ";
        }
        return result;
    }

    /**
     * This method converting number of hundreds from Digit to word.
     * @see Digit
     * */
    private String hundreds(String number){
        String result;
        result = rank.getHundreds().get(number) + " ";
        return result;
    }

    /**
     * This method set name of number class
     * */
    private String classes(Digit digit){
        if(!digit.getTen().equals("1") && (digit.getUnit().equals("2") || digit.getUnit().equals("3") || digit.getUnit().equals("4")))
            return numberClasses.getDegrees().get(currentClass).getNameTwo() + " ";
        if(digit.getUnit().equals("1") && !digit.getTen().equals("1"))
            return numberClasses.getDegrees().get(currentClass).getNameOne() + " ";
        return numberClasses.getDegrees().get(currentClass).getNameFive() + " ";
    }

    /**
     * This method divides incoming number on blocks for 3 number.
     * <p>
     * For example:
     * String (7 345 653) -> List (007, 345, 653).
     * */
    private List<Digit> numberToList(String number){
        List<Digit> result = new ArrayList<>();
        int remain = number.length()%3;

        switch(remain){
            case(1):
                result.add(new Digit("0","0",number.substring(0,1)));
                break;
            case(2):
                result.add(new Digit("0",number.substring(0,1),number.substring(1,2)));
                break;
            default:
                break;
        }

        for(int i=0;i<number.length()/3;i++){
            result.add(new Digit(
                    number.substring(i*3+remain,i*3+remain+1),
                    number.substring(i*3+remain+1,i*3+remain+2),
                    number.substring(i*3+remain+2,i*3+remain+3)
            ));
        }

        return result;
    }

}
