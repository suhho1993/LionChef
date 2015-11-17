package Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import logic.Dish;

public class DBConnectorImpl implements DBConnector {

	private Database database;

	public DBConnectorImpl() {
	}

	@Override
	public void open() {
		database = new Database();

	}

	@Override
	public void close() {
		database.deleteAll();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Database.DBConnector#insert(logic.Dish)
	 */
	@Override
	public boolean insert(Dish dish) {
		if (database.contains(dish.getName())) {
			this.update(dish);
			return true;
		} else {
			return database.insert(dish.getName(), dish.getUrl());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Database.DBConnector#update(logic.Dish)
	 */
	@Override
	public boolean update(Dish dish) {
		return database.update(dish.getName(), dish.getUrl());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Database.DBConnector#displayAll()
	 */
	@Override
	public ArrayList<Dish> displayAll() {

		Set<Map.Entry<String, String>> tempMap = database.getAll();
		ArrayList<Dish> tempList = new ArrayList<Dish>();
		Iterator<Entry<String, String>> it = tempMap.iterator();

		while (it.hasNext()) {
			Map.Entry<String, String> pair = (Entry<String, String>) it.next();
			Dish tempDish = DishCreater.createDish(pair.getKey(), pair.getValue());
			tempList.add(tempDish);
		}

		return tempList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Database.DBConnector#getRandom()
	 */
	@Override
	public Dish getRandom() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Database.DBConnector#delete(logic.Dish)
	 */
	@Override
	public boolean delete(String name) {
		return database.delete(name);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Database.DBConnector#get(logic.Dish)
	 */
	@Override
	public Dish get(String name) {
		Dish tempDish = null;
		String value = database.get(name);
		if (value != null) {
			tempDish = DishCreater.createDish(name, value);
			System.out.println("Dish created!");
		}
		return tempDish;
	}

	public Database getDatabase() {
		return database;
	}

}
