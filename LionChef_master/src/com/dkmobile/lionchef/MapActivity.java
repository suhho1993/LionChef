package com.dkmobile.lionchef;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapCompassManager;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapLocationManager;
import com.nhn.android.maps.NMapOverlay;
import com.nhn.android.maps.NMapOverlayItem;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.NMapView.OnMapStateChangeListener;
import com.nhn.android.maps.NMapView.OnMapViewTouchEventListener;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.maps.nmapmodel.NMapPlacemark;
import com.nhn.android.mapviewer.overlay.NMapCalloutOverlay;
import com.nhn.android.mapviewer.overlay.NMapMyLocationOverlay;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager.OnCalloutOverlayListener;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Toast;
import logic.Dish;

public class MapActivity extends NMapActivity implements OnMapStateChangeListener, OnMapViewTouchEventListener{

	private Dish currentDish;
	
	public static final String API_KEY = "26ac629a3df498de8b4a59d4fcd17f46";
	NMapView mMapView = null;
	NMapController mMapController = null;
	LinearLayout MapContainer;
	
	private NMapMyLocationOverlay mMyLocationOverlay;
	private NMapLocationManager mMapLocationManager;
	private NMapCompassManager mMapCompassManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// ���̹� ������ �ֱ� ���� LinearLayout ������Ʈ
		MapContainer = (LinearLayout) findViewById(R.id.map);

		// ���̹� ���� ��ü ����
		mMapView = new NMapView(this);

		
		// ���̹� ���� ��ü�� APIKEY ����
		mMapView.setApiKey(API_KEY);
		setContentView(mMapView);
		
		// ������ ��ġ�� �� �ֵ��� �ɼ� Ȱ��ȭ
		mMapView.setClickable(true);
		
		// ������ ���� ���� ���� �̺�Ʈ ����
		mMapView.setOnMapStateChangeListener(this);
		mMapView.setOnMapViewTouchEventListener(this);
				
		// ������ ���̹� ���� ��ü�� LinearLayout�� �߰���Ų��.
		//MapContainer.addView(mMapView);

		
		// Ȯ��/��Ҹ� ���� �� ��Ʈ�ѷ� ǥ�� �ɼ� Ȱ��ȭ
		mMapView.setBuiltInZoomControls(true, null);
		//super.setMapDataProviderListener(onDataProviderListener);

		// ���� ��ü�κ��� ��Ʈ�ѷ� ����
		mMapController = mMapView.getMapController();
		
	}

	public void onMapInitHandler(NMapView mapview, NMapError errorInfo) {
		if (errorInfo == null) { // success
			//startMyLocation();//������ġ�� �̵�
			mMapController.setMapCenter(new NGeoPoint(126.978371, 37.5666091), 11);
		} else { // fail
			android.util.Log.e("NMAP", "onMapInitHandler: error=" + errorInfo.toString());
		}
	}


	public void onZoomLevelChange(NMapView mapview, int level) {
	}


	public void onMapCenterChange(NMapView mapview, NGeoPoint center) {
	}

	public void onAnimationStateChange(NMapView arg0, int animType, int animState) {
	}

	public void onMapCenterChangeFine(NMapView arg0) {
	}

	public NMapCalloutOverlay onCreateCalloutOverlay(NMapOverlay arg0, NMapOverlayItem arg1, Rect arg2) {
		return null;
	}



	private void startMyLocation() {

		mMapLocationManager = new NMapLocationManager(this);
		mMapLocationManager.setOnLocationChangeListener(onMyLocationChangeListener);
		
		boolean isMyLocationEnabled = mMapLocationManager.enableMyLocation(true);
		if (!isMyLocationEnabled) {
			Toast.makeText(
					MapActivity.this,
					"Please enable a My Location source in system settings",
					Toast.LENGTH_LONG).show();

			Intent goToSettings = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
			startActivity(goToSettings);
			finish();
		}else{
			
		}
	}
		
		private void stopMyLocation() {
			if (mMyLocationOverlay != null) {
				mMapLocationManager.disableMyLocation();
					if (mMapView.isAutoRotateEnabled()) {
						mMyLocationOverlay.setCompassHeadingVisible(false);
						mMapCompassManager.disableCompass();
						mMapView.setAutoRotateEnabled(false, false);
	
						MapContainer.requestLayout();
					}
			}
		}
		
		private final NMapActivity.OnDataProviderListener onDataProviderListener = new NMapActivity.OnDataProviderListener() {

			@Override
			public void onReverseGeocoderResponse(NMapPlacemark placeMark, NMapError errInfo) {
	
				if (errInfo != null) {
					Log.e("myLog", "Failed to findPlacemarkAtLocation: error=" + errInfo.toString());
					Toast.makeText(MapActivity.this, errInfo.toString(), Toast.LENGTH_LONG).show();
					return;
				}else{
					Toast.makeText(MapActivity.this, placeMark.toString(), Toast.LENGTH_LONG).show();
				}
			}

		};


		private final NMapLocationManager.OnLocationChangeListener onMyLocationChangeListener = new NMapLocationManager.OnLocationChangeListener() {

			@Override
			public boolean onLocationChanged(NMapLocationManager locationManager,
					NGeoPoint myLocation) {

//				if (mMapController != null) {
//					mMapController.animateTo(myLocation);
//				}
				Log.d("myLog", "myLocation  lat " + myLocation.getLatitude());
				Log.d("myLog", "myLocation  lng " + myLocation.getLongitude());


				 findPlacemarkAtLocation(myLocation.getLongitude(), myLocation.getLatitude());
	 //�����浵�� �ּҷ� ��ȯ
				 
				return true;
			}

			@Override
			public void onLocationUpdateTimeout(NMapLocationManager locationManager) {

				// stop location updating
				// Runnable runnable = new Runnable() {
				// public void run() {
				// stopMyLocation();
				// }
				// };
				// runnable.run();

				Toast.makeText(MapActivity.this,
						"Your current location is temporarily unavailable.",
						Toast.LENGTH_LONG).show();
			}

			@Override
			public void onLocationUnavailableArea(
					NMapLocationManager locationManager, NGeoPoint myLocation) {

				Toast.makeText(MapActivity.this,
						"Your current location is unavailable area.",
						Toast.LENGTH_LONG).show();

				stopMyLocation();
			}

		};

	/*public MapActivity(Dish currentDish) {
		super();
		this.currentDish = currentDish;
	}*/
	
	/**
	 * Displays ExceptionActivity Interface when an exception occurs 
	 */
	public void DisplayError(String message){
		//TODO
	}

	@Override
	public void onLongPress(NMapView arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLongPressCanceled(NMapView arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onScroll(NMapView arg0, MotionEvent arg1, MotionEvent arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSingleTapUp(NMapView arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTouchDown(NMapView arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTouchUp(NMapView arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		
	}


}
