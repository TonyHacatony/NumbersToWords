package NumberConverter;

import NumberConverter.domain.Json.NumberJson;
import NumberConverter.domain.Json.Rank;
import com.google.gson.Gson;

import java.io.*;

public class JsonReader {

    public NumberJson getJsonNumbers(){
        NumberJson result = new NumberJson();
        String file = "";

        try {
            file = getClass().getClassLoader().getResource("./static/numberclass.json").getFile();
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader(file)){
            Gson gson = new Gson();
            result = gson.fromJson(reader, NumberJson.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public Rank getJsonRanks(){
        Rank result = new Rank();
        String file = "";

        try {
            file = getClass().getClassLoader().getResource("./static/ranks.json").getFile();
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        try (FileReader reader = new FileReader(file)) {
            Gson gson = new Gson();
            result = gson.fromJson(reader, Rank.class);
        }catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
