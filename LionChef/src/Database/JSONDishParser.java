package Database;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import logic.Dish;
import org.json.simple.JSONObject;

public class JSONDishParser {

	public Dish createDish() throws IOException, ParseException {
		String filePath = "C:\\Users\\Maximilian\\Desktop\\testJSON.json";
		FileReader reader = new FileReader(filePath);
		JSONParser parser = new JSONParser();
		JSONObject dish = (JSONObject) parser.parse(reader);
		String name = (String) dish.get("name");
		String url = (String) dish.get("url");
		return DishCreater.createDish(name, url);
	}
}
