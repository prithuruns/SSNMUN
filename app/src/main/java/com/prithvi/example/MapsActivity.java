package com.prithvi.example;

import android.app.ActionBar;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MapsActivity extends FragmentActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener ,
        LocationListener,
        AdapterView.OnItemSelectedListener{

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    GoogleApiClient mGoogleApiClient;
    LocationRequest mLocationRequest;
    Spinner spinnerfrom,spinnerto;
    int locationfrom,locationto; //0-registation 1-council 2-canteen 3-stores 4-inaugural 5-closing ceremony
    LatLng cse,cseconf,centse,miniaudi,mainaudi,regist,eee,stores,canteen,junc1,junc2,junc3,junc4,junc5,junc6,junc7,junc8,junc9,junc10,junc11;
    //junc1 is from registations to stores
    //junc2 is from stores to miniaudi
    //junc3 is between registation and canteen
    //junc4 is between cse and ece
    //junc 5 is the first junction between stores and eee
    //junc 6 is the second junction between stores and eee
    //junc7 is between library and centse
    //junc8 is first junc between registration to main audi
    //junc9 is second junc between registration to main audi
    //junc10 is third junc between registration to main audi
    //junc11 is first junc between cse to main audi
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();

        buildGoogleApiClient();
        createLocationRequest();

        spinnerfrom=(Spinner) findViewById(R.id.spinner);
        spinnerto=(Spinner) findViewById(R.id.spinner2);
        spinnerfrom.setOnItemSelectedListener(this);
        spinnerto.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerlist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerfrom.setAdapter(adapter);
        spinnerto.setAdapter(adapter);


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                a=0;
            } else {
                a= extras.getInt("council");
            }
        } else {
            a= (int) savedInstanceState.getSerializable("STRING_I_NEED");
        }
    }

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }


    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(50000);
        mLocationRequest.setFastestInterval(3000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }




    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {

        cse=new LatLng(12.751166, 80.197249);
        miniaudi=new LatLng(12.750724, 80.193531);
        centse=new LatLng(12.750448, 80.196102);
        cseconf= new LatLng(12.751644, 80.197184);
        eee=new LatLng(12.749199, 80.196188);
        regist=new LatLng(12.751704, 80.195804);
        stores=new LatLng(12.750989, 80.195222);
        mainaudi=new LatLng(12.752930, 80.200154);
        canteen=new LatLng(12.753275, 80.194570);
        junc1=new LatLng(12.751036, 80.195787);
        junc2=new LatLng(12.750627, 80.195224);
        junc3=new LatLng(12.752368, 80.195803);
        junc4=new LatLng(12.750998, 80.197269);
        junc5=new LatLng(12.750264, 80.195223);
        junc6=new LatLng(12.750166, 80.196060);
        junc7=new LatLng(12.751007, 80.196209);
        junc8=new LatLng(12.752191, 80.196080);
        junc9=new LatLng(12.752387, 80.198639);
        junc10=new LatLng(12.752257, 80.200206);
        junc11=new LatLng(12.752226, 80.197294);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(regist)
                .zoom(17)
                .bearing(90)
                .tilt(45)
                .build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        addmarkers();
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    protected void startLocationUpdates() {
        LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient, mLocationRequest, (LocationListener) this);
    }
    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        updateUI(location);
    }

    private void updateUI(Location loc) {
        MarkerOptions markerOptions=new MarkerOptions();
        markerOptions.position(new LatLng(loc.getLatitude(),loc.getLongitude()));
        mMap.addMarker(markerOptions);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        mMap.clear();
        addmarkers();

        if(parent==spinnerfrom)
        {
            locationfrom=position;
        }
        else if (parent==spinnerto)
        {

            locationto=position;
        }

        decisionpolyline(locationfrom,locationto);
        decisionpolyline(locationto,locationfrom);
    }

    private void decisionpolyline(int jk, int kj) {


        if(jk==0)
        {
            if (kj==0)
            {
                LatLng[] q={regist};
                addpolyline(q);
            }
            else if (kj==1)
            {
                if (a == 1) {
                    LatLng[] q = {regist,junc1,stores,junc2,miniaudi};
                    addpolyline(q);

                } else if (a == 2) {
                    LatLng[] q = {regist,junc1,junc4,cse};
                    addpolyline(q);

                } else if (a == 3) {
                    LatLng[] q = {regist,junc1,stores,junc5,junc6,eee};
                    addpolyline(q);

                } else if (a == 4) {
                    LatLng[] q = {regist,junc1,junc4,cseconf};
                    addpolyline(q);

                } else if (a == 5) {
                    LatLng[] q = {regist,junc1,junc7,centse};
                    addpolyline(q);

                }
            }
            else if(kj==2)
            {
                LatLng[] q={regist,junc3,canteen};
                addpolyline(q);
            }
            else if(kj==3)
            {
                LatLng[] q={regist,junc1,stores};
                addpolyline(q);
            }
            else if(kj==4)
            {
                LatLng[] q={regist,junc1,stores,junc2,miniaudi};
                addpolyline(q);
            }
            else if(kj==5)
            {
                LatLng[] q={regist,junc8,junc9,junc10,mainaudi};
                addpolyline(q);
            }



        }
        else if (jk==2)
        {

            if (kj==0)
            {
                LatLng[] q={canteen,junc3,regist};
                addpolyline(q);
            }
            else if (kj==1)
            {
                if (a == 1) {
                    LatLng[] q = {canteen,junc3,regist,junc1,stores,junc2,miniaudi};
                    addpolyline(q);

                } else if (a == 2) {
                    LatLng[] q = {canteen,junc3,regist,junc1,junc4,cse};
                    addpolyline(q);

                } else if (a == 3) {
                    LatLng[] q = {canteen,junc3,regist,junc1,stores,junc5,junc6,eee};
                    addpolyline(q);

                } else if (a == 4) {
                    LatLng[] q = {canteen,junc3,regist,junc1,junc4,cseconf};
                    addpolyline(q);

                } else if (a == 5) {
                    LatLng[] q = {canteen,junc3,regist,junc1,junc7,centse};
                    addpolyline(q);

                }
            }
            else if(kj==2)
            {
                LatLng[] q={canteen};
                addpolyline(q);
            }
            else if(kj==3)
            {
                LatLng[] q={canteen,junc3,regist,junc1,stores};
                addpolyline(q);
            }
            else if(kj==4)
            {
                LatLng[] q={canteen,junc3,regist,junc1,stores,junc2,miniaudi};
                addpolyline(q);
            }
            else if(kj==5)
            {
                LatLng[] q={canteen,junc3,junc8,junc9,junc10,mainaudi};
                addpolyline(q);
            }

        }
        else if (jk==3)
        {

            if (kj==0)
            {
                LatLng[] q={stores,junc1,regist};
                addpolyline(q);
            }
            else if (kj==1)
            {
                if (a == 1) {
                    LatLng[] q = {stores,junc2,miniaudi};
                    addpolyline(q);

                } else if (a == 2) {
                    LatLng[] q = {stores,junc4,cse};
                    addpolyline(q);

                } else if (a == 3) {
                    LatLng[] q = {stores, junc5, junc6, eee};
                    addpolyline(q);

                } else if (a == 4) {
                    LatLng[] q = {stores,junc4,cseconf};
                    addpolyline(q);

                } else if (a == 5) {
                    LatLng[] q = {stores, junc7,  centse};
                    addpolyline(q);

                }
            }
            else if(kj==2)
            {
                LatLng[] q={stores,junc1,regist,junc3,canteen};
                addpolyline(q);
            }
            else if(kj==3)
            {
                LatLng[] q={stores};
                addpolyline(q);
            }
            else if(kj==4)
            {
                LatLng[] q={stores,junc2,miniaudi};
                addpolyline(q);
            }
            else if(kj==5)
            {
                LatLng[] q={stores,junc1,regist,junc8,junc9,junc10,mainaudi};
                addpolyline(q);
            }

        }
        else if(jk==4)
        {

            if (kj==0)
            {
                LatLng[] q={miniaudi,junc2,stores,junc1,regist};
                addpolyline(q);
            }
            else if (kj==1)
            {
                if (a == 1) {
                    LatLng[] q = {miniaudi};
                    addpolyline(q);

                } else if (a == 2) {
                    LatLng[] q = {miniaudi,junc2,stores, junc4, cse};
                    addpolyline(q);

                } else if (a == 3) {
                    LatLng[] q = {miniaudi, junc2, junc5, junc6, eee};
                    addpolyline(q);

                } else if (a == 4) {
                    LatLng[] q = {miniaudi,junc2,stores, junc4, cseconf};
                    addpolyline(q);

                } else if (a == 5) {
                    LatLng[] q = {miniaudi,junc2,stores, junc7,centse};
                    addpolyline(q);

                }
            }
            else if(kj==2)
            {
                LatLng[] q={miniaudi,junc2,stores,junc1,regist,junc3,canteen};
                addpolyline(q);
            }
            else if(kj==3)
            {
                LatLng[] q={miniaudi,junc2,stores};
                addpolyline(q);
            }
            else if(kj==4)
            {
                LatLng[] q={miniaudi};
                addpolyline(q);
            }

            else if(kj==5)
            {
                LatLng[] q={miniaudi,junc2,stores,junc1,regist,junc8,junc9,junc10,mainaudi};
                addpolyline(q);
            }
        }


        else if (jk==5) {
            if (kj == 0) {
                LatLng[] q = {mainaudi,junc10,junc9,junc8, regist};
                addpolyline(q);
            } else if (kj == 1) {
                if (a == 1) {
                    LatLng[] q = {mainaudi,junc10,junc9,junc8,regist,junc1,stores,junc2,miniaudi};
                    addpolyline(q);

                } else if (a == 2) {
                    LatLng[] q = {mainaudi,junc10,junc9,junc11,cse};
                    addpolyline(q);

                } else if (a == 3) {
                    LatLng[] q = {mainaudi,junc10,junc9,junc8, regist,junc1,stores,junc5,junc6,eee};
                    addpolyline(q);

                } else if (a == 4) {
                    LatLng[] q = {mainaudi,junc10,junc9,junc11,cseconf};
                    addpolyline(q);

                } else if (a == 5) {
                    LatLng[] q = {mainaudi,junc10,junc9,junc11,cse,junc4,junc7,centse};
                    addpolyline(q);

                }
            } else if (kj == 2) {
                LatLng[] q = {mainaudi, junc10,junc9,junc8, junc3, canteen};
                addpolyline(q);
            } else if (kj == 3) {
                LatLng[] q = {mainaudi,junc10,junc9,junc8,regist,junc1,stores};
                addpolyline(q);
            } else if (kj == 4) {
                LatLng[] q = {mainaudi,junc10,junc9,junc8,regist,junc1,stores,junc2,miniaudi};
                addpolyline(q);
            } else if (kj == 5) {
                LatLng[] q = {mainaudi};
                addpolyline(q);
            }
        }


    }

    private void addpolyline(LatLng[] s)
    {
        switch (s.length)
        {
            case 1:
                mMap.addPolyline(new PolylineOptions().geodesic(true)
                        .add(s[0]));
                break;
            case 2:
                mMap.addPolyline(new PolylineOptions().geodesic(true)
                        .add(s[0])
                        .add(s[1]));
                break;
            case 3:
                mMap.addPolyline(new PolylineOptions().geodesic(true)
                        .add(s[0])
                        .add(s[1])
                        .add(s[2]));
                break;
            case 4:
                mMap.addPolyline(new PolylineOptions().geodesic(true)
                        .add(s[0])
                        .add(s[1])
                        .add(s[2])
                        .add(s[3]));
                break;
            case 5:
                mMap.addPolyline(new PolylineOptions().geodesic(true)
                        .add(s[0])
                        .add(s[1])
                        .add(s[2])
                        .add(s[3])
                        .add(s[4]));
                break;
            case 6:
                mMap.addPolyline(new PolylineOptions().geodesic(true)
                        .add(s[0])
                        .add(s[1])
                        .add(s[2])
                        .add(s[3])
                        .add(s[4])
                        .add(s[5]));
                break;
            case 7:
                mMap.addPolyline(new PolylineOptions().geodesic(true)
                        .add(s[0])
                        .add(s[1])
                        .add(s[2])
                        .add(s[3])
                        .add(s[4])
                        .add(s[5])
                        .add(s[6]));
                break;

            case 8:
                mMap.addPolyline(new PolylineOptions().geodesic(true)
                        .add(s[0])
                        .add(s[1])
                        .add(s[2])
                        .add(s[3])
                        .add(s[4])
                        .add(s[5])
                        .add(s[6])
                        .add(s[7]));
                break;
            case 9:
                mMap.addPolyline(new PolylineOptions().geodesic(true)
                        .add(s[0])
                        .add(s[1])
                        .add(s[2])
                        .add(s[3])
                        .add(s[4])
                        .add(s[5])
                        .add(s[6])
                        .add(s[7])
                        .add(s[8]));
                break;
            case 10:
                mMap.addPolyline(new PolylineOptions().geodesic(true)
                        .add(s[0])
                        .add(s[1])
                        .add(s[2])
                        .add(s[3])
                        .add(s[4])
                        .add(s[5])
                        .add(s[6])
                        .add(s[7])
                        .add(s[8])
                        .add(s[9]));
                break;
        }
    }

    private void addmarkers() {
        mMap.addMarker(new MarkerOptions().position(regist).title("SSN").snippet("Your host for a national level MUN."));
        mMap.addMarker(new MarkerOptions().position(cse).title("HRC"));
        mMap.addMarker(new MarkerOptions().position(miniaudi).title("DISEC"));
        mMap.addMarker(new MarkerOptions().position(eee).title("EC"));
        mMap.addMarker(new MarkerOptions().position(centse).title("IAEA"));
        mMap.addMarker(new MarkerOptions().position(cseconf).title("SC"));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
