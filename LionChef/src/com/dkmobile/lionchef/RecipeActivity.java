package com.dkmobile.lionchef;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import logic.Dish;

public class RecipeActivity extends Activity {

	private Dish currentDish;
	private WebView webview;
	private ProgressBar progress;
	String url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recipe);
		webview = (WebView) findViewById(R.id.webview);
		progress = (ProgressBar) findViewById(R.id.web_progress);

		url = getIntent().getStringExtra("url");

		WebSettings webSettings = webview.getSettings();
		webSettings.setJavaScriptEnabled(true);
		webview.getSettings().setBuiltInZoomControls(true);

		webview.loadUrl(url);
		webview.setWebViewClient(new WebViewClient() {
			// 페이지 로딩 시작시 호출
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				progress.setVisibility(View.VISIBLE);
			}

			// 페이지 로딩 종료시 호출
			public void onPageFinished(WebView view, String Url) {
				progress.setVisibility(View.GONE);
			}
		});

	}

	/**
	 * Displays ExceptionActivity Interface when an exception occurs
	 */
	public void DisplayError(String message) {
		// TODO
	}
}
