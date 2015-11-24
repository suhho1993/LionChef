package com.dkmobile.lionchef;

import java.util.*;

import com.dkmobile.lionchef.R.string;

import logic.Dish;

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

	String url;
	Button recipe_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		mTextview_name = (TextView) findViewById(R.id.result_name);
		mTextview_name.setText(getIntent().getStringExtra("name"));

		url = getIntent().getStringExtra("url");

		recipe_btn = (Button) findViewById(R.id.Recipe_btn);
		recipe_btn.setOnClickListener(Displayrecipe);
	}

	/**
	 * Displays the RecipeActivity Interface of the current Dish
	 */
	
	OnClickListener Displayrecipe = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId())
			{
				case R.id.Recipe_btn:
					/*Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					startActivity(webIntent);*/
					Intent recipeIntent = new Intent(DishActivity.this ,RecipeActivity.class);
					recipeIntent.putExtra("url", url);
					startActivity(recipeIntent);
					break;
			}
		
			
		}
	};

	public void DisplayRecipe() {
		// TODO

	}

	/**
	 * Displays the the MapActivity Interface of the current Dish
	 */
	public void DisplayMap() {
		// TODO
	}

}