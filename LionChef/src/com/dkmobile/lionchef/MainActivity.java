package com.dkmobile.lionchef;

import com.dkmobile.newmyobridge.R;

import Controller.Controller;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import logic.Dish;

public class MainActivity extends Activity{
	
	private Controller controller;
	private Dish currentDish;
	
	Button go_btn;
	EditText editText;
	String dishes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		go_btn=(Button)findViewById(R.id.Go_btn);
	
		
		editText = (EditText)findViewById(R.id.textbox);
		
	}
	
	
	/**
	 * Displays the GUI Interface of the current dish 
	 */
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.Go_btn:{
				dishes = editText.getText().toString();
				currentDish=controller.setCurrentDish(dishes);	
					
	             Intent myIntent = new Intent(v.getContext(),DishActivity.class);
	             myIntent.putExtra("name",currentDish.getName());
	             myIntent.putExtra("url",currentDish.getUrl());
	         
	             startActivity(myIntent);
		}
		}
		
		
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