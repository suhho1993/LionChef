package com.dkmobile.lionchef;

import android.app.Activity;
import logic.Dish;

public class MapActivity extends Activity implements Display {

	private Dish currentDish;

	public MapActivity(Dish currentDish) {
		super();
		this.currentDish = currentDish;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}

}
