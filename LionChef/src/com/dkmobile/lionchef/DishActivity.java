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

public class DishActivity extends Activity implements Display {
	private Toast mToast;

	private Button Map_btn;
	private Button Recipe_btn;
	private Button Man_btn;

	private TextView ResTextView;

	private String Dish;

	private Dish currentDish;

	public DishActivity(Dish currentDish) {
		this.currentDish = currentDish;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		Map_btn = (Button) findViewById(R.id.Map_btn);
		Recipe_btn = (Button) findViewById(R.id.Recipe_btn);
		Man_btn = (Button) findViewById(R.id.res_man_btn);

		ResTextView = (TextView) findViewById(R.id.result);
		Dish = savedInstanceState.getString("result", "not sent?");

		ResTextView.setText(Dish);

	}

	// onClick Functions
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.Map_btn:

			break;
		case R.id.Recipe_btn:

			break;

		case R.id.res_man_btn:

			break;
		}
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

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