package Database;

import java.util.ArrayList;

import logic.Dish;

public interface DBConnector {

	/**
	 * Opens database connection
	 */
	public void open();
	
	/**
	 * Closes the current database
	 */
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
	 * @param String name of the dish
	 * @return true if existing dish is successfully deleted from the database
	 */
	public boolean delete(String name);
	
	/**
	 * @param String name of the dish
	 * @return Dish from database with equal name and url
	 * @return null if dish is not available or database is empty
	 */
	public Dish get(String name);
	
	/**
	 * @return arrayList of all the dishes in the database
	 */
	public ArrayList<Dish> getAll();
	
	/**
	 * @return a random dish from the database
	 * 
	 */
	public Dish getRandom();
	
}
