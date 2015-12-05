package Database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.json.simple.parser.ParseException;

import android.content.Context;
import logic.Dish;

public class DBConnectorImpl implements DBConnector  {

	private JSONDishParser database;
	private String fileName;
	private Context context;
	private ArrayList<Dish> dishes;
	private static DBConnectorImpl instance;

	private DBConnectorImpl(String fileName, Context context) {
		this.fileName = fileName;
		this.context = context;
		dishes = new ArrayList<>();
	
		//this.close();
	}

	public static DBConnectorImpl getInstance(String fileName, Context context) {
		if (instance == null) {
			System.out.println("test-DBConnector");
			instance = new DBConnectorImpl(fileName,context);
			
		}

		return instance;
	}

	@Override
	public void open() {
		try {
			if (database == null) {
				database = new JSONDishParser(fileName,context);
			}
			dishes = database.getJson();
			this.insert(new Dish("Chicken", "http://allrecipes.com/recipes/201/meat-and-poultry/chicken/"));
			this.insert (new Dish("Beef", "http://allrecipes.com/recipes/200/meat-and-poultry/beef/"));
			this.insert (new Dish("Fish", "http://allrecipes.com/recipes/411/seafood/fish/"));
			this.insert (new Dish("Lasagna", "http://allrecipes.com/recipes/502/main-dish/pasta/lasagna/"));
			this.insert (new Dish("Spaghetti", "http://allrecipes.com/search/results/?wt=spagetti&sort=re"));
			
		} catch (IOException | ParseException e) {
			System.out.println("File not found creating a new one");
			//dishes.add(new Dish("Chicken", "http://allrecipes.com/recipes/201/meat-and-poultry/chicken/"));
		} 

	}

	@Override
	public void close() {
		try {
			database.insertJson(dishes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Database.DBConnector#insert(logic.Dish)
	 */
	@Override
	public boolean insert(Dish dish) {
		if (dishes.contains(dish)) {
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
			if (dishes.get(i).getName().equals(name)) {
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
		for (int i = 0; i < dishes.size(); i++) {
			if (dishes.get(i).getName().equals(name)) {
				return dishes.get(i);
			}
		}
		return null;
	}

	public JSONDishParser getDatabase() {
		return database;
	}

}
