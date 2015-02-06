package com.example.ormlite;

import java.util.Date;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	DatabaseHelper helper;
	DemoORMLite orm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i(STORAGE_SERVICE, "aaaaaa");
		helper = new DatabaseHelper(getApplicationContext());
		Log.i(STORAGE_SERVICE, "bbbbbb");
		Date d = new Date();
		Log.i(STORAGE_SERVICE, "cccc");
		orm = new DemoORMLite("ismail", 52);
		Log.i(STORAGE_SERVICE, "azzz");
		helper.addData(orm);
	
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
