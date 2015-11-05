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
	private DBConnectorImpl recipeDatabase;
	
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
	 *-sets current dish returned by the database
	 */
	public void setCurrentDish(ArrayList<String> dishList) throws NoDishException {

	}
	
	public boolean insert(String name, String url) {
		return false;
	}

	public boolean update(String name, String url) {
		return false;
	}

	public boolean delete(String name) {
		return false;
	}

	public ArrayList<Dish> displayAll() {
		return null;
	}

	public Dish getRandomDish() {
		return null;
	}

}
