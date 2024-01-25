package adv_sel;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJson {

	public static void main(String[] args) throws IOException, ParseException {
		FileReader file = new FileReader(".\\src\\test\\resources\\JsonReader.json");
		
		JSONParser json= new JSONParser();
		Object obj = json.parse(file);
		
		JSONObject map=(JSONObject) obj;
		
		System.out.println(map.get("browser"));
		
	}

}
