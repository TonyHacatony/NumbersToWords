package converter;

import converter.domain.json.NumberClass;
import converter.domain.json.Rank;
import com.google.gson.Gson;

import java.io.*;

/**
 * This class for read and parse static json for convert number
 * @author Eduard
 * */

public class JsonReader {

    NumberClass getJsonNumbers() throws Exception{
        String file = getClass().getClassLoader().getResource("./static/numberclass.json").getFile();
        FileReader reader = new FileReader(file);
        Gson gson = new Gson();
        return gson.fromJson(reader, NumberClass.class);
    }

    Rank getJsonRanks()throws Exception{
        String file = getClass().getClassLoader().getResource("./static/ranks.json").getFile();
        FileReader reader = new FileReader(file);
        Gson gson = new Gson();
        return gson.fromJson(reader, Rank.class);
    }
}
