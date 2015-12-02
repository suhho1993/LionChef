package Database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import Exceptions.NoDishException;
import logic.Dish;

public class TemporyDatabase implements Database {
	private HashMap<String, String> hashList;

	/**
	 * This is a temporary database. Will be replaced later on with a proper
	 * database
	 */
	public TemporyDatabase() {
		hashList = new HashMap<String, String>();
		this.insert("Chicken", "http://allrecipes.com/recipes/201/meat-and-poultry/chicken/");
		this.insert("Beef", "http://allrecipes.com/recipes/200/meat-and-poultry/beef/");
		this.insert("Fish", "http://allrecipes.com/recipes/411/seafood/fish/");
		this.insert("Lasagna", "http://allrecipes.com/recipes/502/main-dish/pasta/lasagna/");
		this.insert("Spaghetti", "http://allrecipes.com/search/results/?wt=spagetti&sort=re");
		
	}
	
	public void deleteAll(){
		hashList.clear();
	}

	public boolean insert(String name, String url) {
		hashList.put(name.toLowerCase(), url.toLowerCase());
		return false;
	}

	public boolean update(String name, String url){
		if (hashList.containsKey(name.toLowerCase())) {
			hashList.remove(name.toLowerCase());
			this.insert(name.toLowerCase(), url.toLowerCase());
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
		if(hashList.containsKey(name.toLowerCase()) && !hashList.isEmpty()){
			hashList.remove(name.toLowerCase());
			return true;
		} 
		return false;
						
	}

	public String get(String name) {
		String value = hashList.get(name.toLowerCase());
		return value;

	}
	
	public int size(){
		return hashList.size();
	}
	
	
	public boolean isEmpty(){
		
		return hashList.isEmpty();
	}
	
	public boolean contains(String name){
		return hashList.containsKey(name.toLowerCase());
	}
		
}
