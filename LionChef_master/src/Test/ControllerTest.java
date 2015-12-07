package Test;

import Controller.Controller;
import Exceptions.EmptyArrayException;
import Exceptions.NoDishException;
import junit.framework.TestCase;
import logic.CoreLogic;
import logic.Dish;

public class ControllerTest extends TestCase {
	
	CoreLogic core;
	Controller con;
	String dishes;
	String empty;

	public void setUp() throws Exception {
	//core = new CoreLogic();
	//con = new Controller();
	dishes = "Chicken,Beef,Fish,Cheese,Fail";
	empty = "";
	
	}

	
	public void tearDown() throws Exception {
	}


	public void testSetCurrentDish() {
		try {
			Dish dish = con.setCurrentDish(empty);
			System.out.println("Dish name:" + dish.getName());
		} catch (NoDishException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		} catch (EmptyArrayException e) {
			System.out.println(e.getMessage());
			assertTrue(true);
		}
	
		
	
	}


}
