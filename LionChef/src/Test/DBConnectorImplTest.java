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
	Dish pork = new Dish("Pork", "www.pork.com");
	Dish pancake = new Dish("Pancake", "www.pancake.com");
	Dish fish = new Dish("Fish", "www.fish.com");

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
		connection = DBConnectorImpl.getInstance();
		connection.open();
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
		assertEquals(5, connection.getDatabase().size());
		assertFalse(connection.getDatabase().isEmpty());
		connection.insert(pancake);
		assertEquals(6, connection.getDatabase().size());
		connection.insert(fish);
		assertEquals(6, connection.getDatabase().size());
		assertEquals("fish", connection.get("fish").getName());
		assertEquals("pancake", connection.get("pancake").getName());
	}

	/**
	 * Test method for {@link Database.DBConnectorImpl#update(logic.Dish)}.
	 */
	public void testUpdate() {
		Dish fish2 = new Dish("fish", "www.fishes.com");
		assertEquals("www.fish.com", connection.get("fish").getUrl());
		connection.update(fish2);
		assertEquals("www.fishes.com", connection.get("fish").getUrl());
		connection.insert(fish);
		assertEquals("www.fish.com", connection.get("fish").getUrl());
		assertFalse(connection.update(pork));
	}

	/**
	 * Test method for {@link Database.DBConnectorImpl#displayAll()}.
	 */
	public void testDisplayAll() {
		
		
		ArrayList<Dish> testArray = connection.displayAll();
		
		connection.insert(pork);
		testArray = connection.displayAll();
	
		//testArray = connection.displayAll();
		for (int i = 0; i < testArray.size(); i++) {
			System.out.println(testArray.get(i).getName());
			System.out.println(testArray.get(i).getUrl());
		}
		
		connection.delete("pork");
		testArray = connection.displayAll();
		assertEquals(5, testArray.size());
	}

	/**
	 * Test method for {@link Database.DBConnectorImpl#getRandom()}.
	 */
	public void testGetRandom() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Database.DBConnectorImpl#delete(java.lang.String)}
	 * .
	 */
	public void testDelete() {
		assertTrue(connection.delete("Lasagna"));
		assertFalse(connection.delete("Pork"));
		assertEquals(4, connection.getDatabase().size());
		assertEquals(4, connection.getDatabase().size());
		connection.close();
		assertFalse(connection.delete("Fish"));
	}

	/**
	 * Test method for {@link Database.DBConnectorImpl#get(java.lang.String)}.
	 */
	public void testGet() {
		assertEquals("www.fish.com", connection.get("fish").getUrl());
		assertEquals(5, connection.getDatabase().size());
		assertEquals("www.fish.com", connection.get("Fish").getUrl());
		assertEquals("fish", connection.get("fish").getName());
		assertNull(connection.get("pancake"));
		connection.close();
		assertNull(connection.get("fish"));

	}

}
