package Test;

import java.util.ArrayList;

import junit.framework.TestCase;
import logic.CoreLogic;

public class CoreLogicTest extends TestCase {

	CoreLogic coreLogic;
	ArrayList<String> dishes;
	
	
	public void testCoreLogic() {
		fail("Not yet implemented");
	}

	public void testGetCurrentDish() {
		fail("Not yet implemented");
	}

	public void testSetCurrentDish() {
		
	}

	public void testGetRecipeDatabase() {
		fail("Not yet implemented");
	}

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		coreLogic=new CoreLogic();
		dishes.add("chicken");
		dishes.add("beef");
		dishes.add("pork");
		
		//coreLogic.setCurrentDish(dishes);
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

	public void testSetRecipeDatabase() {
		fail("Not yet implemented");
	}

}
