package Database;

import java.util.ArrayList;

import logic.Dish;

public class DBConnectorImpl implements DBConnector{

	private RecipeManager recipeManager;

	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean insert(Dish dish) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Dish dish) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Dish get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Dish> displayAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dish getRandom() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
