package com.dkmobile.lionchef;

import Controller.Controller;
import android.app.Activity;
import android.os.Bundle;
import logic.Dish;

public class MainActivity extends Activity{
	
	private Controller controller;
	private Dish currentDish;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	
	/**
	 * Displays the GUI Interface of the current dish 
	 */
	void displayDish() {
		// TODO
		
	}

	

	/**
	 * Displays the GUI Interface of the dish manager
	 */
	void displayManager() {
		// TODO
	}

	/**
	 * @return controller
	 */
	public Controller getCtrl() {
		return controller;
	}

	/**
	 * @param ctrl
	 * set the current controller
	 */
	public void setCtrl(Controller ctrl) {
		controller = ctrl;
	}

	/**
	 * @return currentDish
	 */
	public Dish getCurrentDish() {
		return currentDish;
	}
	
	/**
	 * Displays ExceptionActivity Interface when an exception occurs 
	 */
	public void DisplayError(String message){
		//TODO
	}


}