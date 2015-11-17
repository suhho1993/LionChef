package Test;
import java.util.ArrayList;

import Exceptions.NoDishException;
import junit.framework.TestCase;
import logic.CoreLogic;

public class CoreLogicTest extends TestCase {
	
	
	CoreLogic core;
	ArrayList<String> dishes;
	
	public CoreLogicTest(String name) {
		

		super(name);
	}

	protected void setUp() throws Exception {
		core = new CoreLogic();
		dishes = new ArrayList<String>();
		dishes.add("Chicken");
//		dishes.add("Beef");
//		dishes.add("Fail");
//		dishes.add("Fish");
//		dishes.add("Lasagna");
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void test(){	
		System.out.println("Test");
		try {
		core.setCurrentDish(dishes);
		System.out.println(core.getCurrentDish().getName());
	} catch (NoDishException e) {
		assertTrue(true);
	}

	}
	
	
}


