package com.dkmobile.lionchef;

import java.util.*;

import Controller.Controller;
import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import logic.Dish;

public class MainActivity extends Activity implements Display {
	private Toast mToast;

	private Display display;
	private Controller Ctrl;
	private Dish currentDish;
	
	private Button Go_btn;
	private Button Man_btn;
	private EditText Text;
	private String DishText;
	private ArrayList<String> Dish_List;

	int i = 0;

	@Override
	public void display() {
		// TODO Auto-generated method stub
	}
	
	
	/**
	 * Create a new Object of type DishActivity 
	 */
	void displayDish() {
		// TODO
		DishActivity tempdisplay = new DishActivity(currentDish);
	}

	void displayManager() {
		// TODO
	}

	public Controller getCtrl() {
		return Ctrl;
	}

	public void setCtrl(Controller ctrl) {
		Ctrl = ctrl;
	}

	public Dish getCurrentDish() {
		return currentDish;
	}

	public void setCurrentDish(Dish currentDish) {
		this.currentDish = currentDish;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Go_btn = (Button) findViewById(R.id.Go_btn);
		Text = (EditText) findViewById(R.id.editText1);

	}

	// onClick Functions
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.Go_btn:
			DishText = Text.getText().toString();
			showToast(DishText);
			break;
		case R.id.Man_btn:
			Dish_List = Ctrl.MakeArray(DishText);
			if (i < Dish_List.size()) {
				showToast(Dish_List.get(i));
				i++;
			} else {
				i = 0;
			}
			Intent res = new Intent();
			res.setClass(this, DishActivity.class);
			res.putExtra("result", Dish_List.get(i));
			startActivity(res);
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
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