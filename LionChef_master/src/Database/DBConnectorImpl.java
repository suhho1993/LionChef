package Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.json.simple.parser.ParseException;

import android.content.Context;
import logic.Dish;

public class DBConnectorImpl implements DBConnector {

	private JSONDishParser database;
	private String fileName;
	private Context context;
	private ArrayList<Dish> dishes;
	private static DBConnectorImpl instance;

	private DBConnectorImpl(String fileName, Context context) {
		this.fileName = fileName;
		this.context = context;
		dishes = new ArrayList<>();

		// this.close();
	}

	public static DBConnectorImpl getInstance(String fileName, Context context) {
		if (instance == null) {
			System.out.println("test-DBConnector");
			instance = new DBConnectorImpl(fileName, context);

		}

		return instance;
	}

	@Override
	public void open() {
		try {
			if (database == null) {
				database = new JSONDishParser(fileName, context);
			}
			dishes = database.getJson();

		} catch (IOException | ParseException e) {
			System.out.println("Exception caught-File does not exist");
		}

	}

	@Override
	public void close() {
		try {
			database.insertJson(dishes);
		} catch (IOException e) {
			System.out.println("Exception caught-IO");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Database.DBConnector#insert(logic.Dish)
	 */
	@Override
	public boolean insert(Dish dish) {
		for (int i = 0; i < dishes.size(); i++) {
			if (dishes.get(i).getName().equals(dish.getName().toLowerCase())) {
				update(dish,i);
				return true;
			}	
		}
		return dishes.add(dish);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Database.DBConnector#update(logic.Dish)
	 */
	@Override
	public boolean update(Dish dish, int i) {
		System.out.println(i);
		Dish check = dishes.set(i, dish);
		if (check.equals(dish)) {
			return true;
		}

		return false;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Database.DBConnector#displayAll()
	 */
	@Override
	public ArrayList<Dish> getAll() {
		return dishes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Database.DBConnector#getRandom()
	 */
	@Override
	public Dish getRandom() {
		ArrayList<Dish> temp = dishes;
		Collections.shuffle(temp);
		return temp.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Database.DBConnector#delete(logic.Dish)
	 */
	@Override
	public boolean delete(String name) {
		for (int i = 0; i < dishes.size(); i++) {
			if (dishes.get(i).getName().equals(name.toLowerCase())) {
				dishes.remove(i);
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Database.DBConnector#get(logic.Dish)
	 */
	@Override
	public Dish get(String name) {
		for (int i = 0; i < dishes.size(); i++) {
			if (dishes.get(i).getName().equals(name.toLowerCase())) {
				return dishes.get(i);
			}
		}
		return null;
	}

	public JSONDishParser getDatabase() {
		return database;
	}

}
