package logic;

import java.util.ArrayList;
import java.util.StringTokenizer;

import Database.DBConnectorImpl;
import Database.DishCreater;
import Exceptions.EmptyArrayException;
import Exceptions.NoDishException;

/**
 * @author suhho CoreLogic class functionality: -Create a new dish if not
 *         already exists in RecipeManager -Create Random Dish if not are parsed
 *         by the user -Manage database for the dishes
 * 
 */
public class CoreLogic {

	private Dish currentDish;
	private DBConnectorImpl DBConnector;
	private DishCreater dishCreater;

	/**
	 * Constructor Creates and opens new database connection
	 */
	public CoreLogic() {
		DBConnector = DBConnectorImpl.getInstance();
		DBConnector.open();
	}

	/**
	 * @return the currentDish
	 */
	public Dish getCurrentDish() {
		return currentDish;
	}

	/**
	 * @param dishList
	 *            - array of strings
	 * @throws EmptyArrayException 
	 * @exception -NoDishException
	 *                thrown when dish is not available in the database -filters
	 *                array of String to retrieve one random string -searches
	 *                database for that string -sets and returns currentDish
	 *                returned by the database
	 */
	public void setCurrentDish(ArrayList<String> dishes) throws NoDishException, EmptyArrayException {
		if (dishes.size() != 0) {
			String str = RandomFilter.filterStrings(dishes);
			currentDish = DBConnector.get(str);
			if (currentDish == null) {
				throw new NoDishException("Dish does not exist: " + str);
			}
		} else {
			throw new EmptyArrayException("Empty  array");
		}
	}
	
	public boolean insert(String name, String value){
		return DBConnector.insert(new Dish(name,value));
		
	}
	
	public boolean delete(String name){
		return DBConnector.delete(name);
	}

	/**
	 * @return current database connection
	 */
	public DBConnectorImpl getRecipeDatabase() {
		return DBConnector;
	}
	
	public ArrayList<Dish> getAll(){
		return DBConnector.getAll();
	}
	
	public Dish getRandom(){
		return DBConnector.getRandom();
	}

	/**
	 * @param recipeDatabase
	 *            Set current database connection
	 */
	public void setRecipeDatabase(DBConnectorImpl recipeDatabase) {
		this.DBConnector = recipeDatabase;
	}

}
