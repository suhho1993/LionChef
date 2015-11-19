package com.dkmobile.lionchef;

import Controller.Controller;
import Exceptions.EmptyArrayException;
import Exceptions.NoDishException;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import logic.Dish;

public class MainActivity extends Activity {

	private Toast mToast;

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
		controller = new Controller();

		go_btn = (Button) findViewById(R.id.Go_btn);

		editText = (EditText) findViewById(R.id.textbox);

	}

	/**
	 * Displays the GUI Interface of the current dish
	 */
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.Go_btn: {
			dishes = editText.getText().toString();
			Intent myIntent = new Intent(this, DishActivity.class);

			try {
				currentDish = controller.setCurrentDish(dishes);
				startActivity(myIntent);
			} catch (NoDishException e) {
				e.printStackTrace();
				showToast(e.getMessage());
			} catch (EmptyArrayException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				showToast(e.getMessage());
			}

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