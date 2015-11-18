package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dkmobile.lionchef.MainActivity;

import Controller.Controller;
import Exceptions.EmptyArrayException;
import Exceptions.NoDishException;
import logic.CoreLogic;
import logic.Dish;

public class ControllerTest {
	
	CoreLogic core;
	Controller con;
	String dishes;
	String empty;

	@Before
	public void setUp() throws Exception {
	core = new CoreLogic();
	con = new Controller();
	dishes = "Chicken,Beef,Fish,Cheese,Fail";
	empty = "";
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
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
