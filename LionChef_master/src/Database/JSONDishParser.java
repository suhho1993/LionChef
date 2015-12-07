package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import android.annotation.SuppressLint;
import android.content.Context;
import logic.Dish;

/**
 * @author Maximilian
 * This class is responsible for reading and writing from and to a json file. 
 */

@SuppressLint("NewApi")
public class JSONDishParser implements Database {

	private String fileName;
	private Context context;
	private final JsonParser parser;

	
	/**
	 * @param fileName of json
	 * @param context 
	 * Constructor
	 */
	public JSONDishParser(String fileName, Context context) {
		this.context = context;
		this.fileName = fileName;
		parser = new JsonParser();
	}

	/**
	 * @return ArrayList of dishes from json file
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public ArrayList<Dish> getJson() throws FileNotFoundException, IOException, ParseException {
		ArrayList<Dish> dishes = new ArrayList<Dish>();
		String jsonFile = jsonToStringFromFile();
		JsonObject object = (JsonObject) parser.parse(jsonFile);

		for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
			JsonArray array = entry.getValue().getAsJsonArray();
			for (int i = 0; i < array.size(); i++) {
				String name = array.get(i).getAsJsonObject().getAsJsonPrimitive("name").getAsString();
				String url = array.get(i).getAsJsonObject().getAsJsonPrimitive("url").getAsString();
				dishes.add(DishCreater.createDish(name, url));
			}
		}
		return dishes;
	}

	
	/**
	 * @param Arraylist of dishes that need to be written to json file
	 * @throws IOException
	 */
	public void insertJson(ArrayList<Dish> dishes) throws IOException {
		JsonObject inputObj = new JsonObject();
		JsonArray jsonDishes = new JsonArray();
		JsonObject newObject;
		for (int i = 0; i < dishes.size(); i++) {
			newObject = new JsonObject();
			newObject.addProperty("id", i);
			newObject.addProperty("name", dishes.get(i).getName().toLowerCase());
			newObject.addProperty("url", dishes.get(i).getUrl().toLowerCase());
			jsonDishes.add(newObject);

		}
		inputObj.add("dishes", jsonDishes);
		Gson gson = new Gson();
		String jsonRepresentation = gson.toJson(inputObj);

		writeJsonToFile(jsonRepresentation);

	}
		
	private void writeJsonToFile(String jsonRepresentation) throws IOException {
		FileOutputStream fos = context.openFileOutput(fileName, Context.MODE_PRIVATE);
		fos.write(jsonRepresentation.getBytes());
		fos.close();
	}
	
	private String jsonToStringFromFile() throws IOException {
		String json = null;		
		int size;
			FileInputStream is = context.openFileInput(fileName);
			size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			is.close();
			json = new String(buffer, "UTF-8");
			return json;
	}

}
