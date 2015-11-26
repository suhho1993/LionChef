package Test;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import Database.JSONDishParser;
import junit.framework.TestCase;
import logic.Dish;

public class JSONDishParserTest extends TestCase {

	private JSONDishParser parser = new JSONDishParser();
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCreateDish() {
		try {
			Dish dish = parser.createDish();
			assertEquals("Chicken", dish.getName());
			assertEquals("www.chicken.com",dish.getUrl());
			System.out.println("Name: " + dish.getName() + " URL: " + dish.getUrl());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
