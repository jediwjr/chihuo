package com.example.jediwjr.chihuo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RestaurantMapActivity extends FragmentActivity implements OnMapReadyCallback {
    public final static String EXTRA_LATLNG = "EXTRA_LATLNG";
    MapFragment mapFragment;
    private int number = 11;
    private LatLng toMark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_map);

        mapFragment =
                (MapFragment) getFragmentManager().findFragmentById(R.id.restaurant_map);

        // This function automatically initializes the maps system and the view.
        mapFragment.getMapAsync(this);

        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            Log.e("bundle check", "no bundle");
            toMark = bundle.getParcelable(EXTRA_LATLNG);
        } else {
            Log.e("bundle check", "got bundle");
        }

        IntentFilter filter = new IntentFilter();
        filter.addAction("GOOGLEMAP_ZOOM");
        this.registerReceiver(new ZoomMap(), filter);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        if (toMark != null) {
            Log.e("toMark", toMark.toString());
            map.addMarker(new MarkerOptions().position(toMark).title("Marker"));
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(toMark, 5));
//            map.moveCamera(CameraUpdateFactory.newLatLng(toMark));
            map.animateCamera(CameraUpdateFactory.zoomTo(number), 2000, null);
        }
    }

    class ZoomMap extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                number = Integer.parseInt(extras.getString("ZOOM"));
                mapFragment.getMapAsync(RestaurantMapActivity.this);
            }
        }
    }
}
