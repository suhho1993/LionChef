package Test;
import java.util.ArrayList;

import Exceptions.EmptyArrayException;
import Exceptions.NoDishException;
import junit.framework.TestCase;
import logic.CoreLogic;

public class CoreLogicTest extends TestCase {
	
	
	CoreLogic core;
	ArrayList<String> dishes;
	ArrayList<String> empty;
	
	public CoreLogicTest(String name) {
		

		super(name);
	}

	protected void setUp() throws Exception {
		//core = new CoreLogic();
		dishes = new ArrayList<String>();
		empty = new ArrayList<String>();
		dishes.add("qefwef");
		dishes.add("wefewfw");
		dishes.add("Fail");
		dishes.add("wefewf");
		dishes.add("efwf");
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testArray(){	
		try {
		core.setCurrentDish(dishes);
	} catch (NoDishException e) {
		System.out.println(e.getMessage());
		assertTrue(true);
	} catch (EmptyArrayException e) {
		System.out.println(e.getMessage());
		assertTrue(true);
	}

	}

	
	
}


