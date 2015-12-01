package com.dkmobile.lionchef;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import logic.Dish;

public class DishManagerActivity extends Activity {

	private Toast mToast;
	
	private ArrayList<Dish> dishList;
	private Dish currentDish;
	private ListView list;

	private Button addNew;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipemanager);
		addNew=(Button)findViewById(R.id.man_add);
		
		addNew.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent i = new Intent(DishManagerActivity.this, AddRecipe.class);
				startActivityForResult(i, 12);
			}
		});		
		
		dishList = (ArrayList<Dish>) getIntent().getSerializableExtra("allDish");

		myDishAdapter adapter = new myDishAdapter(this, R.layout.dish_item, dishList);

		list = (ListView) findViewById(R.id.man_dish_list);
		list.setAdapter(adapter);

		addClickListener();

	}

	class myDishAdapter extends BaseAdapter {
		Context con;
		LayoutInflater inflacter;
		ArrayList<Dish> arD;
		int layout;

		public myDishAdapter(Context context, int alayout, ArrayList<Dish> aarD) {
			con = context;
			inflacter = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			arD = aarD;
			layout = alayout;
		}

		@Override
		public int getCount() {
			return arD.size();
		}

		@Override
		public Object getItem(int position) {
			return arD.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = inflacter.inflate(layout, parent, false);
			}
			TextView dishName = (TextView) convertView.findViewById(R.id.item_dish_name);
			TextView dishUrl = (TextView) convertView.findViewById(R.id.item_dish_url);

			currentDish = arD.get(position);

			dishName.setText(arD.get(position).getName());
			dishUrl.setText(arD.get(position).getUrl());

			return convertView;
		}

	}

	private void addClickListener() {
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> av, View v, int pos, long id) {
				Dish dish2snd = dishList.get(pos);
				Intent i = new Intent(DishManagerActivity.this, RecipeEdit.class);
				i.putExtra("Dish", dish2snd);
				startActivityForResult(i, 12);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 12: {
			if (resultCode == RESULT_OK) {
				Dish dish = (Dish) data.getSerializableExtra("Dish");
				Intent curDish = new Intent();
				
				if (data.getStringExtra("delete").equals("true")) {
					curDish.putExtra("delete","true");
					curDish.putExtra("Dish", dish);
				} else {
					curDish.putExtra("Dish", dish);
					curDish.putExtra("delete","false");
				}
				setResult(RESULT_OK, curDish);
				finish();
			}
			break;
		}
		}
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
