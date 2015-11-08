package com.dkmobile.lionchef;

import android.app.Activity;
import logic.Dish;

public class RecipeActivity extends Activity{

	private Dish currentDish;
	
	
	public RecipeActivity(Dish currentDish) {
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
