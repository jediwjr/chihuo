package com.example.jediwjr.chihuo;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class RestaurantListActivity extends AppCompatActivity implements RestaurantListFragment.OnItemSelectListener {
    RestaurantListFragment listFragment;
    RestaurantGridFragment gridFragment;

    @Override
    public void onItemSelected(int position) {
        gridFragment.onItemSelected(position);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        Log.e("Life cycle test", "We are at onCreate()");
        // Show different fragments based on screen size.
        //add list view
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                YelpApi yelp = new YelpApi();
                yelp.searchForBusinessesByLocation("dinner", "San Francisco, CA", 20);
                return null;
            }
        }.execute();


        if (findViewById(R.id.fragment_container) != null) {
            Intent intent = getIntent();
            if (intent.getExtras() != null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_list_container, new BackendListFragment()).commit();
            } else {
                listFragment = new RestaurantListFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_list_container, listFragment).commit();
            }
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Life cycle test", "We are at onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Life cycle test", "We are at onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Life cycle test", "We are at onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Life cycle test", "We are at onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Life cycle test", "We are at onDestroy()");
    }

}
