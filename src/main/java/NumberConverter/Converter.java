package NumberConverter;

import NumberConverter.domain.Digit;
import NumberConverter.domain.Json.NumberJson;
import NumberConverter.domain.Json.Rank;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    private List<Digit> digitsList = new ArrayList<>();
    private Rank rank = new Rank();
    private NumberJson numberClasses = new NumberJson();
    private int currentClass = 0;

    public String convert(String number){
        StringBuilder builder = new StringBuilder();
        digitsList.addAll(numberToList(number));
        rank = new JsonReader().getJsonRanks();
        numberClasses = new JsonReader().getJsonNumbers();
        currentClass = digitsList.size()-1;

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
                            element.getUnit(),
                            numberClasses.getDegrees().get(currentClass).getNameOne(),
                            element.getTen()));
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
    
    private String units(String unit,String numberClass,String tens){
        String result = "";
        if(tens.equals("1")) return result;
        if(numberClass.equals("тысяча")) {
            result = rank.getThousandUnits().get(unit) + " ";
        }else{
            result = rank.getUnits().get(unit) + " ";
        }
        return result;
    }

    private String tens(String tens,String unit){
        String result;
        if(tens.equals("1")){
            result = rank.getTensAndUnits().get(unit) + " ";
        }else{
            result = rank.getTens().get(tens) + " ";
        }
        return result;
    }

    private String hundreds(String number){
        String result;
        result = rank.getHundreds().get(number) + " ";
        return result;
    }

    private String classes(Digit digit){
        if(!digit.getTen().equals("1") && (digit.getUnit().equals("2") || digit.getUnit().equals("3") || digit.getUnit().equals("4")))
            return numberClasses.getDegrees().get(currentClass).getNameTwo() + " ";
        if(digit.getUnit().equals("1") && !digit.getTen().equals("1"))
            return numberClasses.getDegrees().get(currentClass).getNameOne() + " ";
        return numberClasses.getDegrees().get(currentClass).getNameFive() + " ";
    }

    /*  this method divides incoming argument on blocks for 3 number, for example:
    *   String 7345653 -> List (007, 345, 653).
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
