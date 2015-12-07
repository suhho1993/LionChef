package Database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

import logic.Dish;

public interface DBConnector {

	/**
	 * Opens database connection
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void open() throws FileNotFoundException, IOException, ParseException;
	
	/**
	 * Closes the current database
	 * @throws IOException 
	 */
	public void close() throws IOException;
	
	/**
	 * @param dish
	 * @return true if dish is successfully inserted into the database
	 */
	public boolean insert(Dish dish);
	
	/**
	 * @param dish
	 * @return true if existing dish is successfully updated in the database
	 */
	public boolean update(Dish dish, int i);
	
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
