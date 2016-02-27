package ca.stevenlyall.midterm3160feb29;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements MyFragment.OnFragmentInteractionListener {

	private final String TAG = "MainActivity";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		hideFragment();
		showFragment();
	}

	@Override
	public void onFragmentInteraction(String str) {
		Log.d(TAG, "onFragmentInteraction: " + str);

		android.support.v4.app.FragmentManager fragManager = getSupportFragmentManager();
		MyFragment fragment = (MyFragment) fragManager.findFragmentById(R.id.myFragment);
		//fragment.setImage();
		fragment.setTextView(str);
	}

	public void hideFragment() {
		android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
		ft.hide(fm.findFragmentById(R.id.myFragment));
		ft.commit();
	}

	public void showFragment() {
		android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
		ft.show(fm.findFragmentById(R.id.myFragment));
		ft.commit();
	}
}
