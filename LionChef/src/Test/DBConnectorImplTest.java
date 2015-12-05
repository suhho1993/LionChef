/**
 * 
 */
package Test;

import java.util.ArrayList;

import Database.DBConnectorImpl;
import junit.framework.TestCase;
import logic.Dish;

/**
 * @author Maximilian
 *
 */
public class DBConnectorImplTest extends TestCase {

	DBConnectorImpl connection;
	Dish pork = new Dish("pork", "www.pork.com");
	Dish pancake = new Dish("pancake", "www.pancake.com");
	Dish chicken = new Dish("chicken", "www.chicken.com");
	Dish fish2 = new Dish("butter Fish", "www.butterfish.com");
	
	/**
	 * @param name
	 */
	public DBConnectorImplTest(String name) {
		super(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		//connection = DBConnectorImpl.getInstance();
		connection.open();
		connection.insert(fish2);
		connection.insert(pancake);
		connection.insert(chicken);
		super.setUp();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		connection = null;
		super.tearDown();
	}

	/**
	 * Test method for {@link Database.DBConnectorImpl#insert(logic.Dish)}.
	 */
	public void testInsert() {
		assertEquals(5, connection.getAll().size());
		assertFalse(connection.getAll().isEmpty());
		connection.insert(pancake);
		assertEquals(5, connection.getAll().size());
		connection.insert(new Dish("cheese", "www.cheese.com"));
		assertEquals(6, connection.getAll().size());
		assertEquals("cheese", connection.get("cheese").getName());
		assertEquals("pancake", connection.get("pancake").getName());
	}

	/**
	 * Test method for {@link Database.DBConnectorImpl#update(logic.Dish)}.
	 */
	public void testUpdate() {
		assertEquals("www.butterfish.com",connection.get("butter Fish").getUrl());
		fish2.setUrl("hans string");
		connection.update(fish2);
		Dish dish = connection.getAll().get(3);
		dish.setName("peter");
		connection.update(dish);
	}

	/**
	 * Test method for {@link Database.DBConnectorImpl#displayAll()}.
	 */
	public void testDisplayAll() {

		ArrayList<Dish> testArray = connection.getAll();

		connection.insert(pork);
		// testArray = connection.getAll();
		//
		// //testArray = connection.displayAll();
		// for (int i = 0; i < testArray.size(); i++) {
		// System.out.println(testArray.get(i).getName());
		// System.out.println(testArray.get(i).getUrl());
		// }

		connection.delete("pork");
		testArray = connection.getAll();
		assertEquals(5, testArray.size());
	}

	/**
	 * Test method for {@link Database.DBConnectorImpl#getRandom()}.
	 */
	public void testGetRandom() {
		System.out.println("This is the random: " + connection.getRandom().getName());
	}

	/**
	 * Test method for {@link Database.DBConnectorImpl#delete(java.lang.String)}
	 * .
	 */
	public void testDelete() {
		assertFalse(connection.delete("pork"));
		assertTrue(connection.delete("beef"));
		assertFalse(connection.delete("Lasagna"));
		assertEquals(4, connection.getAll().size());
		print(connection.getAll());
		// connection.close();
		// assertFalse(connection.delete("Fish"));
	}

	/**
	 * Test method for {@link Database.DBConnectorImpl#get(java.lang.String)}.
	 */
	public void testGet() {
		assertEquals("chicken",connection. get("chicken").getName());
		assertNull(connection.get("cheese"));
		Dish dish = new Dish("fisherino","www.fisherino.com");
		connection.insert(dish);
		assertEquals("www.fisherino.com",connection. get("fisherino").getUrl());
		connection.delete("fisherino");
		assertNull(connection.get("fisherino"));
	}

	private void print(ArrayList<Dish> testArray) {
		// testArray = connection.displayAll();
		for (int i = 0; i < testArray.size(); i++) {
			System.out.println(testArray.get(i).getName());
			System.out.println(testArray.get(i).getUrl());

		}

	}
}
