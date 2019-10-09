package converter;

import converter.domain.json.NumberJson;
import converter.domain.json.Rank;
import com.google.gson.Gson;

import java.io.*;

public class JsonReader {

    NumberJson getJsonNumbers() throws Exception{
        String file = getClass().getClassLoader().getResource("./static/numberclass.json").getFile();
        FileReader reader = new FileReader(file);
        Gson gson = new Gson();
        return gson.fromJson(reader, NumberJson.class);
    }

    Rank getJsonRanks()throws Exception{
        String file = getClass().getClassLoader().getResource("./static/ranks.json").getFile();
        FileReader reader = new FileReader(file);
        Gson gson = new Gson();
        return gson.fromJson(reader, Rank.class);
    }
}
