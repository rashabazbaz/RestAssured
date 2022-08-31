package Core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonFile {
	public static JSONArray readFile(String filePath) throws FileNotFoundException, IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(filePath));

        JSONArray jo = (JSONArray) obj;

        return jo;
	}
	
}
