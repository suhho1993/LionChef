package Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Database.JSONDishParser;
import junit.framework.TestCase;
import logic.Dish;


public class JSONDishParserTest extends TestCase {

	public JSONDishParser p;
	
	protected void setUp() throws Exception {
		
		super.setUp();
		//p = new JSONDishParser();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCreateDish(){
		try {
			ArrayList<Dish> dishes = new ArrayList<Dish>();
			Dish spaghetti = new Dish("Spaghetti","www.spaghetti.com");
			Dish pasta = new Dish("pasta","www.pasta.com");
			dishes.add(new Dish("Beef", "www.beef.com"));
			dishes.add(new Dish("fish", "www.fish.com"));
			dishes.add(spaghetti);
			dishes.add(pasta);
			System.out.println(dishes.size());
			for(int i = 0; i < dishes.size(); i++){
				System.out.println(dishes.get(i).getName());
			}
			p.insertJson(dishes);
			dishes.remove(pasta);
			p.insertJson(dishes);
			dishes.remove(spaghetti);
			p.insertJson(dishes);
			//assertEquals("chicken", dishes.get(0).getName());
			//assertEquals("www.chicken.com", dishes.get(0).getUrl());
		} catch (FileNotFoundException e) {
			System.out.println("test");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}
