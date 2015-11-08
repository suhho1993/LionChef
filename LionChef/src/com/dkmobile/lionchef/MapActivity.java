package com.dkmobile.lionchef;

import android.app.Activity;
import logic.Dish;

public class MapActivity extends Activity{

	private Dish currentDish;

	public MapActivity(Dish currentDish) {
		super();
		this.currentDish = currentDish;
	}
	
	/**
	 * Displays ExceptionActivity Interface when an exception occurs 
	 */
	public void DisplayError(String message){
		//TODO
	}


}
