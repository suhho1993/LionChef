package logic;

import java.util.ArrayList;

/**
 * @author Maximilian
 *	Randomly returns a String from parsed array of Strings
 */
public class RandomFilter {
	
	
	/**
	 * @param DishList
	 * @return String
	 */
	static public String filterStrings(ArrayList<String> DishList){
		int rand=(int) (Math.random()*DishList.size());
		return DishList.get(rand);
	}
}
