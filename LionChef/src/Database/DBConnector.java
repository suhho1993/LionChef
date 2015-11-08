package Database;

import java.util.ArrayList;

import logic.Dish;

public interface DBConnector {

	public void open();
	public void close();
	/**
	 * @param dish
	 * @return true if dish is successfully inserted into the database
	 */
	public boolean insert(Dish dish);
	/**
	 * @param dish
	 * @return true if existing dish is successfully updated in the database
	 */
	public boolean update(Dish dish);
	/**
	 * @param dish
	 * @return true if existing dish is successfully deleted from the database
	 */
	public boolean delete(Dish dish);
	/**
	 * @param dish
	 * @return Dish from database with equal name and url
	 */
	public Dish get(Dish dish);
	/**
	 * @return arrayList of all the dishes in the database
	 */
	public ArrayList<Dish> displayAll();
	/**
	 * @return a random dish from the database
	 */
	public Dish getRandom();
	
}
