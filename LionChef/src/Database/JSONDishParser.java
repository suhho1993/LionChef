package Database;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.parser.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import logic.Dish;

@SuppressLint("NewApi")
public class JSONDishParser implements Database {

	
	private final File jsonFile;
	private final JsonParser parser;

	public JSONDishParser(String fileName, Context context) throws IOException {
		jsonFile = jsonToStringFromAssetFolder(fileName, context);
		parser = new JsonParser();
	}

	public ArrayList<Dish> getJson() throws FileNotFoundException, IOException, ParseException {
		ArrayList<Dish> dishes = new ArrayList<Dish>();
		JsonObject object = (JsonObject) parser.parse(new FileReader(jsonFile));

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
		System.out.println(jsonDishes);
		inputObj.add("dishes", jsonDishes);
		Gson gson = new Gson();
		String jsonRepresentation = gson.toJson(inputObj);

		FileWriter writer = new FileWriter(jsonFile);
		writeJsonToFile(writer, jsonRepresentation);

	}

	private void writeJsonToFile(FileWriter writer, String jsonRepresentation) throws IOException {
		writer.write(jsonRepresentation);
		writer.close();
	}

	private File jsonToStringFromAssetFolder(String fileName, Context context) throws IOException {

		AssetManager manager = context.getAssets();
		InputStream inputStream = manager.open(fileName);

		File file = createFileFromInputStream(fileName, inputStream);
		return file;
	}

	private File createFileFromInputStream(String fileName, InputStream inputStream) {

		try {
			File f = new File("dishes.json");
			OutputStream outputStream = new FileOutputStream(f);
			byte buffer[] = new byte[1024];
			int length = 0;

			while ((length = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, length);
			}

			outputStream.close();
			inputStream.close();

			return f;
		} catch (IOException e) {
			// Logging exception
		}

		return null;
	}
}
