package Database;

import java.util.ArrayList;

import logic.Dish;

public interface DBConnector {

	public void open();
	public void close();
	public boolean insert(Dish dish);
	public boolean update(Dish dish);
	public boolean delete(String name);
	public Dish get(String name);
	public ArrayList<Dish> displayAll();
	public Dish getRandom();
	
}
