package com.example.owner.finalexam181206;

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

public class MapsThebooth extends FragmentActivity implements OnMapReadyCallback {

private static final int REQUEST_CODE_PERMISSIONS = 1000;


//다른 회사는 여기 바꾸어야 함
private static final LatLng TB_GHM = new LatLng(37.569252,127.00012800000002);//더부스 광화문
private static final LatLng TB_SYS = new LatLng(37.529193,126.96840580000003);//더부스 신용산
private static final LatLng TB_GCG = new LatLng(37.5408693,127.06601369999998);//더부스건대커먼그라운드
private static final LatLng TB_G1 = new LatLng(37.4939612,127.02793889999998);//더부스강남1호점
private static final LatLng TB_GLD = new LatLng(37.5393588,126.98768999999993);//더부스경리단
private static final LatLng TB_SS = new LatLng(37.5099705,127.05694059999996);//더부스삼성

private Marker mTB_GHM;
private Marker mTB_SYS;
private Marker mTB_GCG;
private Marker mTB_G1;
private Marker mTB_GLD;
private Marker mTB_SS;
//여기까지


private GoogleMap mMap;
private FusedLocationProviderClient mFLPC;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_thebooth);
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
        mTB_GHM=mMap.addMarker(new MarkerOptions().position(TB_GHM).title("더부스 광화문"));
        mTB_GHM.setTag(0);
        mTB_SYS=mMap.addMarker(new MarkerOptions().position(TB_SYS).title("더부스 신용산"));
        mTB_SYS.setTag(0);
        mTB_GCG=mMap.addMarker(new MarkerOptions().position(TB_GCG).title("더부스 건대커먼그라운드"));
        mTB_GCG.setTag(0);
        mTB_G1=mMap.addMarker(new MarkerOptions().position(TB_G1).title("더부스 강남1호점"));
        mTB_G1.setTag(0);
        mTB_GLD=mMap.addMarker(new MarkerOptions().position(TB_GLD).title("더부스 경리단점"));
        mTB_GLD.setTag(0);
        mTB_SS=mMap.addMarker(new MarkerOptions().position(TB_SS).title("더부스 삼성점"));
        mTB_SS.setTag(0);
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
