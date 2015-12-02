package Database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.simple.parser.ParseException;

import logic.Dish;

public class DBConnectorImpl implements DBConnector {

	private JSONDishParser database;
	private ArrayList<Dish> dishes;
	private static DBConnectorImpl instance;

	private DBConnectorImpl() {
	}
	
	public static DBConnectorImpl getInstance(String databaseName){
		if(instance == null){
			instance = new DBConnectorImpl();
		}
		
		return instance;
	}

	@Override
	public void open() throws FileNotFoundException, IOException, ParseException {
		database = new JSONDishParser();
		dishes = database.getJson();

	}

	@Override
	public void close() throws IOException {
		database.insertJson(dishes);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Database.DBConnector#insert(logic.Dish)
	 */
	@Override
	public boolean insert(Dish dish) {
		if (dishes.contains(dish.getName())) {
			this.update(dish);
			return true;
		} else {
			return dishes.add(dish);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Database.DBConnector#update(logic.Dish)
	 */
	@Override
	public boolean update(Dish dish) {
		Dish check = dishes.set(dishes.indexOf(dish), dish);
		if(check.equals(dish)){
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
		for(int i = 0; i < dishes.size(); i++){
			if(dishes.get(i).getName().equals(name)){
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
		Dish tempDish = null;
		for(int i = 0; i < dishes.size(); i++){
			if(dishes.get(i).getName().equals(name)){
				return dishes.get(i);
			}
		}
		return null;
	}

	public JSONDishParser getDatabase() {
		return database;
	}

}
