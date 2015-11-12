package com.dkmobile.lionchef;

import java.util.*;

import logic.Dish;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DishActivity extends Activity{

	TextView mTextview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	       mTextview = (TextView)findViewById(R.id.result);
	       mTextview.setText(getIntent().getStringExtra("name")+" "+getIntent().getStringExtra("url"));
	}

	private Dish currentDish;

	public DishActivity(Dish currentDish) {
		this.currentDish = currentDish;
	}
	
	/**
	 * Displays the RecipeActivity Interface of the current Dish
	 */
	public void DisplayRecipe(){
		//TODO
	}
	
	/**
	 * Displays the the MapActivity Interface of the current Dish
	 */
	public void DisplayMap(){
		//TODO
	}

}