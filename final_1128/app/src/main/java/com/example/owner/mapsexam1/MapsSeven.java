package com.example.owner.mapsexam1;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class MapsSeven extends FragmentActivity implements OnMapReadyCallback {

    private static final int REQUEST_CODE_PERMISSIONS = 1000;


    //다른 회사는 여기 바꾸어야 함
    private static final LatLng SV_LW = new LatLng(37.5126064, 127.102713);//세븐브로이 롯데월드점
    private static final LatLng SV_YUD = new LatLng(37.5304826, 126.92130939999993);//세븐브로이 여의도점
    private static final LatLng SV_BS = new LatLng( 37.5730079, 126.83734649999996);//세븐브로이 발산점
    private static final LatLng SV_GR = new LatLng(37.4957935, 127.11880680000001);//세븐브로이 가락점
    private static final LatLng SV_GA = new LatLng(37.4756657, 126.98088110000003);//세븐브로이 관악
    private static final LatLng SV_SP = new LatLng(37.4855999, 127.12450899999999);//세븐브로이 송파

    private Marker mSV_LW;
    private Marker mSV_YUD;
    private Marker mSV_BS;
    private Marker mSV_GR;
    private Marker mSV_GA;
    private Marker mSV_SP;
    //여기까지


    private GoogleMap mMap;
    private FusedLocationProviderClient mFLPC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_seven);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mFLPC = LocationServices.getFusedLocationProviderClient(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Seoul and move the camera
        LatLng seoul = new LatLng(37.5640907,126.99794029999998);
        mMap.addMarker(new MarkerOptions().position(seoul).title("Marker in Seoul"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(seoul));


        //다른회사는 여기 바꾸어야함
        mSV_LW=mMap.addMarker(new MarkerOptions().position(SV_LW).title("세븐브로이 롯데월드점"));
        mSV_LW.setTag(0);
        mSV_YUD=mMap.addMarker(new MarkerOptions().position(SV_YUD).title("세븐브로이 여의도점"));
        mSV_YUD.setTag(0);
        mSV_BS=mMap.addMarker(new MarkerOptions().position(SV_BS).title("세븐브로이 발산점"));
        mSV_BS.setTag(0);
        mSV_GR=mMap.addMarker(new MarkerOptions().position(SV_GR).title("세븐브로이 가락점"));
        mSV_GR.setTag(0);
        mSV_GA=mMap.addMarker(new MarkerOptions().position(SV_GA).title("세븐브로이 관악"));
        mSV_GA.setTag(0);
        mSV_SP=mMap.addMarker(new MarkerOptions().position(SV_SP).title("세븐브로이 송파"));
        mSV_SP.setTag(0);
        //여기까지






    }

    public void open(View view) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},REQUEST_CODE_PERMISSIONS);
            return;
        }
        mFLPC.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null){
                    LatLng myLocation = new LatLng(location.getLatitude(),location.getLongitude());
                    mMap.addMarker(new MarkerOptions().position(myLocation).title("현재위치"));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_CODE_PERMISSIONS:
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"권한체크거부됨",Toast.LENGTH_SHORT).show();
                }

        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}


