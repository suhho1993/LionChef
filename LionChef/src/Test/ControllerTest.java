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
//	MinActivity main;
//	Controller con;
//	String dishes;

	@Before
	public void setUp() throws Exception {
//		core = new CoreLogic();
//		main = new MainActivity();
//		con = new Controller(core,main);
//		dishes = "Chicken,Beef,Fish,Cheese,Fail";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetCurrentDish() {
//		try {
//			Dish dish = con.setCurrentDish(dishes);
//			System.out.println("Dish name:" + dish.getName());
//		} catch (NoDishException e) {
//			System.out.println(e.getMessage());
//			assertTrue(true);
//		} catch (EmptyArrayException e) {
//			System.out.println(e.getMessage());
//			assertTrue(true);
//		}
	
		
	
	}

	@Test
	public void testGetCoreLogic() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMainDisplay() {
		fail("Not yet implemented");
	}

}
