package com.dkmobile.lionchef;

import android.app.Activity;
import logic.Dish;

public class RecipeActivity extends Activity implements Display{

	private Dish currentDish;
	
	
	public RecipeActivity(Dish currentDish) {
		super();
		this.currentDish = currentDish;
	}


	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
