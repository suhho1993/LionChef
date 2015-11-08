package Controller;

import java.util.*;

import com.dkmobile.lionchef.MainActivity;

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
	 * @param dishList array of Strings
	 * Calls logic class setDish method
	 */
	public Dish setCurrentDish(ArrayList<String> dishList) {
		//TODO
		return null;
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