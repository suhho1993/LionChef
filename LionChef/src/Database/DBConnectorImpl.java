package Database;

import java.util.ArrayList;

import logic.Dish;

public class DBConnectorImpl implements DBConnector{

	private Database database;

	public DBConnectorImpl(){
		
	}
	
	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
	/* (non-Javadoc)
	 * @see Database.DBConnector#insert(logic.Dish)
	 */
	@Override
	public boolean insert(Dish dish) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see Database.DBConnector#update(logic.Dish)
	 */
	@Override
	public boolean update(Dish dish) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see Database.DBConnector#displayAll()
	 */
	@Override
	public ArrayList<Dish> displayAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see Database.DBConnector#getRandom()
	 */
	@Override
	public Dish getRandom() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see Database.DBConnector#delete(logic.Dish)
	 */
	@Override
	public boolean delete(Dish dish) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see Database.DBConnector#get(logic.Dish)
	 */
	@Override
	public Dish get(Dish dish) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
