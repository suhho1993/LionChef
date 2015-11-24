package com.dkmobile.lionchef;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import logic.Dish;

public class RecipeActivity extends Activity{

	private Dish currentDish;
	private WebView webview;
	String url;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipe);
		webview = (WebView)findViewById(R.id.webview);

	    url = getIntent().getStringExtra("url");
	       
	    WebSettings webSettings = webview.getSettings();
	    webSettings.setJavaScriptEnabled(true);
	       
	    //webview.setWebChromeClient(new WebChromeClient());
	    //webview.addJavascriptInterface(new JavaScriptMethods(), "url");
	    webview.loadUrl(url);

	}

	/**
	 * Displays ExceptionActivity Interface when an exception occurs 
	 */
	public void DisplayError(String message){
		//TODO
	}
}
