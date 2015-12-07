package com.dkmobile.lionchef;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import logic.Dish;

public class AddRecipe extends Activity{

	Dish currentDish;
	EditText name;
	EditText url;

	Button save;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_recipe);

		name = (EditText) findViewById(R.id.add_name);
		url = (EditText) findViewById(R.id.add_url);
		save = (Button) findViewById(R.id.add_save);
		
		save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String mName;
				String mUrl;
				mName = name.getText().toString();
				mUrl = url.getText().toString();
				
				Dish dish = new Dish(mName, mUrl);
				Intent curDish = new Intent();
				
				curDish.putExtra("delete", "false");
				curDish.putExtra("Dish", dish);
				setResult(RESULT_OK, curDish);
				finish();
			}
		});

		currentDish = (Dish) getIntent().getSerializableExtra("Dish");

	}

}
