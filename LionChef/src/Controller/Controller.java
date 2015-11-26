package Controller;

import java.util.*;

import com.dkmobile.lionchef.MainActivity;

import Exceptions.EmptyArrayException;
import Exceptions.NoDishException;
import android.content.Intent;
import logic.CoreLogic;
import logic.Dish;

public class Controller {
	private CoreLogic coreLogic;
	
	public Controller(){
		coreLogic=new CoreLogic();
	}
	

	/**
	 * @param dishList Strings
	 * Calls logic class setDish method
	 * @throws NoDishException 
	 * @throws EmptyArrayException 
	 */
	public Dish setCurrentDish(String dishes) throws NoDishException, EmptyArrayException {
		//makes string into array of strings
		ArrayList<String> v = new ArrayList<String>();
		StringTokenizer tkn = new StringTokenizer(dishes, ", ");
		while (tkn.hasMoreTokens()) {
			v.add(tkn.nextToken());
		}
		coreLogic.setCurrentDish(v);
		return coreLogic.getCurrentDish();
	}
	
	public Dish getRandom(){
		return coreLogic.getCurrentDish();
	}
	
	public boolean insert(Dish dish){
		return coreLogic.insert(dish);
	}
	
	public boolean delete(String name){
		return coreLogic.delete(name);
	}
	
	public ArrayList<Dish> getAll(){
		return coreLogic.getAll();
	}
	/**
	 * @return CoreLogic
	 */
	public CoreLogic getCoreLogic() {
		return coreLogic;
	}

}