package com.dkmobile.lionchef;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import logic.Dish;

public class AddRecipe extends Activity {
	private Toast mToast;

	private Dish currentDish;
	private EditText name;
	private EditText url;

	private Button save;

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
				switch (v.getId()) {
				case R.id.add_save:
				case R.id.man_add:
					String mName;
					String mUrl;
					mName = name.getText().toString();
					mUrl = url.getText().toString();
					if (mName.equals("") && mUrl.equals("")) {
						showToast("Enter Name & Url");
						break;
					} else if (mName.equals("")) {
						showToast("Enter Name");
						break;
					} else if (mUrl.equals("")) {
						showToast("Enter Name");
						break;
					}

					Dish dish = new Dish(mName, mUrl);
					Intent curDish = new Intent();

					curDish.putExtra("delete", "false");
					curDish.putExtra("Dish", dish);
					setResult(RESULT_OK, curDish);
					finish();

				}
			}
		});

		currentDish = (Dish) getIntent().getSerializableExtra("Dish");

	}

	private void showToast(String text) {
		if (mToast == null) {
			mToast = Toast.makeText(this, text, Toast.LENGTH_SHORT);
		} else {
			mToast.setText(text);
		}
		mToast.show();
	}

}
