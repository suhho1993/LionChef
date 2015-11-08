package logic;

import java.util.ArrayList;

import Database.DBConnectorImpl;
import Exceptions.NoDishException;

/**
 * @author suhho
 * CoreLogic class functionality:
 * -Create a new dish if not already exists in RecipeManager
 * -Create Random Dish if not are parsed by the user
 * -Manage database for the dishes 
 * 
 */
public class CoreLogic {

	private Dish currentDish;
	private DBConnectorImpl DBConnection;
	
	
	/**
	 * Constructor 
	 * Creates and opens new database connection
	 */
	public CoreLogic(){
		DBConnection = new DBConnectorImpl();
	}
	
	/**
	 * @return the currentDish
	 */
	public Dish getCurrentDish() {
		return currentDish;
	}

	/**
	 * @param dishList - array of strings
	 * @exception -NoDishException thrown when dish is not available in the database
	 *-filters array of String to retrieve one random string
	 *-searches database for that string
	 *-sets and returns currentDish returned by the database
	 */
	public Dish setCurrentDish(ArrayList<String> dishList) throws NoDishException {
		//TODO
		return null;
	}

	/**
	 * @return current database connection
	 */
	public DBConnectorImpl getRecipeDatabase() {
		return DBConnection;
	}

	/**
	 * @param recipeDatabase
	 * Set current database connection
	 */
	public void setRecipeDatabase(DBConnectorImpl recipeDatabase) {
		this.DBConnection = recipeDatabase;
	}
	
	
}
