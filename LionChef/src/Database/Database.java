package Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Exceptions.NoDishException;
import logic.Dish;

public class Database {
	private HashMap<String, String> hashList;

	/**
	 * This is a temporary database. Will be replaced later on with a proper
	 * database
	 */
	public Database() {
		hashList = new HashMap<String, String>();
		this.insert("Chicken,", "www.chicken.com");
		this.insert("Beef,", "www.beef.com");
		this.insert("Fish,", "www.fish.com");
		this.insert("Lasagna,", "www.lasagna.com");
		this.insert("Spaghetti,", "www.spaghetti.com");
	}
	
	public void deleteAll(){
		hashList.clear();
	}

	public boolean insert(String name, String url) {
		hashList.put(name, url);
		return false;
	}

	public boolean update(String name, String url){
		if (hashList.containsKey(name)) {
			hashList.remove(name);
			this.insert(name, url);
			return true;
		} else {
			return false;
		}
	}

	public Set<Map.Entry<String,String>> getAll() {
		return this.hashList.entrySet();
	}

	public HashMap<String, String> getRandom() {
		return null;
	}

	public boolean delete(String name) {
		if (hashList.containsKey(name) && !hashList.isEmpty()) {
			hashList.remove(name);
			return true;
		} else {
			return false;
		}
	}

	public String get(String name) {
		return hashList.get(name);

	}

}
