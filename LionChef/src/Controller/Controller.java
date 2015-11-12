package Controller;

import java.util.*;

import com.dkmobile.lionchef.MainActivity;

import Exceptions.NoDishException;
import android.content.Intent;
import logic.CoreLogic;
import logic.Dish;

public class Controller {
	private final CoreLogic coreLogic;
	private final MainActivity mainDisplay;

	public Controller(CoreLogic logic, MainActivity mainDisplay){
		this.coreLogic = logic;
		this.mainDisplay = mainDisplay;
	}
	
	
	/**
	 * @param dishList Strings
	 * Calls logic class setDish method
	 * @throws NoDishException 
	 */
	public Dish setCurrentDish(String dishes) throws NoDishException {
		//makes string into array of strings
		ArrayList<String> v = new ArrayList<String>();
		StringTokenizer tkn = new StringTokenizer(dishes, ",");
		while (tkn.hasMoreTokens()) {
			v.add(tkn.nextToken());
		}
		coreLogic.setCurrentDish(v);
		return coreLogic.getCurrentDish();
	}

	/**
	 * @return CoreLogic
	 */
	public CoreLogic getCoreLogic() {
		return coreLogic;
	}

	/**
	 * @return MainActivity
	 */
	public MainActivity getMainDisplay() {
		return mainDisplay;
	}
}