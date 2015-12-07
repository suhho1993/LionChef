package com.dkmobile.lionchef;

import java.io.Serializable;
import java.util.*;

import logic.Dish;
//import android.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DishActivity extends Activity {

	TextView mTextview_name;

	private Dish currentDish;

	String url;
<<<<<<< HEAD
	Button recipe_btn;
	Button man_btn;
	Button map_btn;
=======
	private Button recipe_btn;
	private Button man_btn;
	private Button map_btn;
>>>>>>> origin/sh

	@Override

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		currentDish = (Dish) getIntent().getSerializableExtra("dish");

		mTextview_name = (TextView) findViewById(R.id.result_name);

		mTextview_name.setText(currentDish.getName());
		url = currentDish.getUrl();

		map_btn = (Button) findViewById(R.id.Map_btn);
		map_btn.setOnClickListener(Displayrecipe);

		recipe_btn = (Button) findViewById(R.id.Recipe_btn);
		recipe_btn.setOnClickListener(Displayrecipe);

		man_btn = (Button) findViewById(R.id.res_man_btn);
		man_btn.setOnClickListener(Displayrecipe);
		
		map_btn = (Button)findViewById(R.id.Map_btn);
		map_btn.setOnClickListener(Displayrecipe);

	}

	/**
	 * Displays the RecipeActivity Interface of the current Dish
	 */

	OnClickListener Displayrecipe = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.Recipe_btn:
				/*
				 * Intent webIntent = new Intent(Intent.ACTION_VIEW,
				 * Uri.parse(url)); startActivity(webIntent);
				 */
				Intent recipeIntent = new Intent(DishActivity.this, RecipeActivity.class);
				recipeIntent.putExtra("url", url);
				startActivity(recipeIntent);
				break;
			case R.id.res_man_btn:
				Intent recipeIntent1 = new Intent(DishActivity.this, RecipeEdit.class);
				recipeIntent1.putExtra("Dish", currentDish);
				startActivityForResult(recipeIntent1, 13);
				break;
			case R.id.Map_btn:
				Intent mapIntent = new Intent(DishActivity.this, MapActivity.class);
				startActivity(mapIntent);
				break;
			}

		}
	};

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 13: {
			if (resultCode == RESULT_OK) {
				Dish dish = (Dish) data.getSerializableExtra("Dish");
				Intent curDish = new Intent();

				if (data.getStringExtra("delete").equals("true")) {
					curDish.putExtra("delete", "true");
					curDish.putExtra("Dish", dish);
				} else {
					curDish.putExtra("Dish", dish);
					curDish.putExtra("delete", "false");
				}
				setResult(RESULT_OK, curDish);
				finish();
			}
			break;
		}
		}
	}

	/**
	 * Displays the the MapActivity Interface of the current Dish
	 */
	public void DisplayMap() {
		// TODO
	}

}