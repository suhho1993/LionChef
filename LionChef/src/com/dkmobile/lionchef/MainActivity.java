package com.dkmobile.lionchef;

import java.util.ArrayList;

import com.dkmobile.lionchef.R.id;

import Controller.Controller;
import Exceptions.EmptyArrayException;
import Exceptions.NoDishException;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import logic.Dish;

public class MainActivity extends Activity {

	private Toast mToast;

	private Controller controller;
	private Dish currentDish;
	private ArrayList<Dish> dishList;
	private Dish manDish;

	private Button go_btn;
	private Button man_btn;
	private Button rand_btn;

	private EditText editText;
	private String dishes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		controller = new Controller();

		go_btn = (Button) findViewById(R.id.main_Go_btn);
		rand_btn = (Button) findViewById(R.id.main_feeln_btn);
		editText = (EditText) findViewById(R.id.textbox);
	}

	/**
	 * Displays the GUI Interface of the current dish
	 */
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.main_Go_btn: {
			dishes = editText.getText().toString();
			Intent myIntent = new Intent(this, DishActivity.class);

			try {
				currentDish = controller.setCurrentDish(dishes);
				myIntent.putExtra("dish", currentDish);
				startActivityForResult(myIntent, 2);
			} catch (NoDishException e) {
				e.printStackTrace();
				showToast(e.getMessage());
			} catch (EmptyArrayException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				showToast(e.getMessage());
			}

			break;
		}
		case R.id.main_man_btn: {
			Intent manIntent = new Intent(this, DishManagerActivity.class);
			dishList = controller.getAll();
			manIntent.putExtra("allDish", dishList);
			startActivityForResult(manIntent, 1);
			break;
		}
		case R.id.main_feeln_btn: {
			currentDish = controller.getRandom();
			Intent mIntent = new Intent(this, DishActivity.class);
			mIntent.putExtra("dish", currentDish);
			startActivityForResult(mIntent, 2);
			break;
		}
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 1: {
			if (resultCode == RESULT_OK) {
				manDish = (Dish) data.getSerializableExtra("Dish");
				// showToast(data.getStringExtra("delete"));
				if (data.getStringExtra("delete").equals("true")) {
					controller.delete(manDish.getName());
					showToast("Deleted.." + manDish.getName());
				} else {
					// showToast(manDish.getName());
					controller.insert(manDish);
					showToast("Inserted.." + manDish.getName());
				}
			}
			break;
		}
		case 2: {
			if (resultCode == RESULT_OK) {
				manDish = (Dish) data.getSerializableExtra("Dish");
				// showToast(data.getStringExtra("delete"));
				if (data.getStringExtra("delete").equals("true")) {
					controller.delete(manDish.getName());
					showToast("Deleted.." + manDish.getName());
				} else {
					// showToast(manDish.getName());
					controller.insert(manDish);
					showToast("Inserted.." + manDish.getName());
				}
			}
			break;
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
	 *            set the current controller
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
	public void DisplayError(String message) {
		// TODO
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