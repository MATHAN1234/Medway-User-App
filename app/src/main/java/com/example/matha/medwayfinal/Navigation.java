package com.example.matha.medwayfinal;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matha.medwayfinal.Common.Common;
import com.example.matha.medwayfinal.Helper.CustomInfoWindow;
import com.example.matha.medwayfinal.Model.Notification;
import com.example.matha.medwayfinal.Model.FCMResponse;
import com.example.matha.medwayfinal.Model.Rider;
import com.example.matha.medwayfinal.Model.Sender;
import com.example.matha.medwayfinal.Model.Token;
import com.example.matha.medwayfinal.Remote.IFCMService;
import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQuery;
import com.firebase.geofire.GeoQueryEventListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;
import com.google.maps.android.SphericalUtil;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Navigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {


    SupportMapFragment mapFragment;

    //Location

    private GoogleMap mMap;
    //play services
    private static final int MY_PERMISSION_REQUEST_CODE = 7192;
    private static final int PLAY_SERVICE_RES_REQUEST = 300193;
    private LocationRequest mLocationRequest;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;


    private static int UPDATE_INTERVAL = 5000;
    private static int FATEST_INTERVAL = 3000;
    private static int DISPLACEMENT = 10;

    DatabaseReference ref;
    GeoFire geofire;

    Marker mUserMarker;

    ImageView imgExpandable;
    BottomSheetRiderFragment mBottomSheet;
    Button btnPickUp;

    boolean isDriverFound = false;
    String driverId="";
    int radius = 1; //1km
    int distance = 1; //1km
    private static final int LIMIT = 3 ;// 3 km



    IFCMService mServices;


    //presense system

    DatabaseReference driversAvailable;

    PlaceAutocompleteFragment place_location, place_destination;
    AutocompleteFilter typefilter;

    String mPlaceLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mServices = Common.getFCMService();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View navigationHeader = navigationView.getHeaderView(0);
        TextView txtname =  (TextView)navigationHeader.findViewById(R.id.txtName);
        txtname.setText(Common.currentRider.getName());
        //map

        mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);




        imgExpandable =(ImageView)findViewById(R.id.imageExpandable);
        btnPickUp = (Button)findViewById(R.id.button4);
        btnPickUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isDriverFound)
                    requestPickup(FirebaseAuth.getInstance().getCurrentUser().getUid());
                else
                    sendRequestToDriver(driverId);

            }
        });

        place_location = (PlaceAutocompleteFragment) getFragmentManager().findFragmentById(R.id.place_location);

        typefilter = new AutocompleteFilter.Builder().setTypeFilter(AutocompleteFilter.TYPE_FILTER_ADDRESS).setTypeFilter(3).build();

        place_location.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                mPlaceLocation = place.getAddress().toString();

                mMap.clear();

                mUserMarker = mMap.addMarker(new MarkerOptions().position(place.getLatLng()).icon(BitmapDescriptorFactory.defaultMarker()).title("Pick up here"));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(place.getLatLng(),15.0f));
                BottomSheetRiderFragment mBottomSheet = BottomSheetRiderFragment.newInstance(mPlaceLocation);

            }

            @Override
            public void onError(Status status) {

            }
        });


        imgExpandable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBottomSheet.show(getSupportFragmentManager(),mBottomSheet.getTag());
            }
        });

        setUpLocation();

        updateFirebaseToken();
    }

    private void updateFirebaseToken() {

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference tokens= db.getReference(Common.token_tbl);

        Token token = new Token(FirebaseInstanceId.getInstance().getToken());
        tokens.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(token);
    }
/**
    private void sendRequestToDriver(String driverId) {
        DatabaseReference tokens= FirebaseDatabase.getInstance().getReference(Common.token_tbl);
        tokens.orderByKey().equalTo(driverId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot postSnapShot:dataSnapshot.getChildren())
                {
                    Token token = postSnapShot.getValue(Token.class);
                    String json_lat_lng= new Gson().toJson(new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude()));
                    String riderToke = FirebaseInstanceId.getInstance().getToken();
                    com.example.matha.medwayfinal.Model.Notification data = new com.example.matha.medwayfinal.Model.Notification(riderToke,json_lat_lng);
                    Sender content = new Sender(data, token.getToken());


                    mServices.sendMessage(content).enqueue(new Callback<FCMResponse>() {
                        @Override
                        public void onResponse(Call<FCMResponse> call, Response<FCMResponse> response) {
                            if(response.body().success==1) {

                                Toast.makeText(Navigation.this, "Request Sent", Toast.LENGTH_SHORT).show();
                                btnPickUp.setEnabled(false);
                            }
                            else
                                Toast.makeText(Navigation.this, "Failed", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<FCMResponse> call, Throwable t) {
                            Log.e("Error",t.getMessage());
                        }
                    });
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
**/

private void sendRequestToDriver(String driverId) {
    DatabaseReference tokens = FirebaseDatabase.getInstance().getReference(Common.token_tbl);
    tokens.orderByKey().equalTo(driverId)
            .addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for(DataSnapshot postSnapShot:dataSnapshot.getChildren()){
                        Token token = postSnapShot.getValue(Token.class); // Get token object from database with key
                        //: Make new payload - Convert LatLng to json
                        String json_lat_lng = new Gson().toJson(new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude()));
                        String riderToke = FirebaseInstanceId.getInstance().getToken();
                        Notification data = new Notification(riderToke, json_lat_lng); //: Send it to driver app and we will deserialize it again.
                        Sender content = new Sender(token.getToken(), data); //: Send this data to token
                        mServices.sendMessage(content)
                                .enqueue(new Callback<FCMResponse>() {
                                    @Override
                                    public void onResponse(Call<FCMResponse> call, Response<FCMResponse> response) {
                                        if(response.body().success == 1)
                                            Toast.makeText(Navigation.this, "Request Sent!", Toast.LENGTH_SHORT).show();
                                        else
                                            Toast.makeText(Navigation.this, "Failed", Toast.LENGTH_SHORT).show();
                                    }
                                    @Override
                                    public void onFailure(Call<FCMResponse> call, Throwable t) {
                                        Log.e("Error", t.getMessage());
                                    }
                                });
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
}

private void requestPickup(String uid) {
        DatabaseReference dbRequest = FirebaseDatabase.getInstance().getReference(Common.pickup_request);
        GeoFire mGeoFire = new GeoFire(dbRequest);
        mGeoFire.setLocation(uid,new GeoLocation(mLastLocation.getLatitude(),mLastLocation.getLongitude()));

        if(mUserMarker.isVisible())
        {
            mUserMarker.remove();
        }
        mUserMarker =mMap.addMarker(new MarkerOptions().title("pickUp here")
                .snippet("").position(new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude())).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        mUserMarker.showInfoWindow();

        btnPickUp.setText("Getting your Driver");

        findDriver();

    }

    private void findDriver() {
        DatabaseReference drivers = FirebaseDatabase.getInstance().getReference(Common.drivers);
        GeoFire gfdrivers = new GeoFire(drivers);

        GeoQuery geoQuery = gfdrivers.queryAtLocation(new GeoLocation(mLastLocation.getLatitude(),mLastLocation.getLongitude()),radius);
        geoQuery.removeAllListeners();
        geoQuery.addGeoQueryEventListener(new GeoQueryEventListener() {
            @Override
            public void onKeyEntered(String key, GeoLocation location) {
                //if found
                if(!isDriverFound)
                {
                    isDriverFound= true;
                    driverId = key;
                    btnPickUp.setText("Call driver");
                    Toast.makeText(Navigation.this, "" + key, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onKeyExited(String key) {

            }

            @Override
            public void onKeyMoved(String key, GeoLocation location) {

            }

            @Override
            public void onGeoQueryReady() {
                //if driver not found increase the distance

                if(!isDriverFound && radius < LIMIT)
                {
                    radius++;
                    findDriver();
                }
                else
                {
                    Toast.makeText(Navigation.this, "no Available Ambulance near you", Toast.LENGTH_SHORT).show();
                    btnPickUp.setText("Request Pick");
                }
            }

            @Override
            public void onGeoQueryError(DatabaseError error) {

            }
        });
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case MY_PERMISSION_REQUEST_CODE:
                if(grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
                {
                    if(checkPlayServices())
                    {
                        buildGoogleApiClient();
                        createLocationRequest();
                        displayLocation();

                    }
                }
        }
    }

    private void setUpLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //request runtime permission
            ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION
            },MY_PERMISSION_REQUEST_CODE);
        }
        else{
            if(checkPlayServices())
            {
                buildGoogleApiClient();
                createLocationRequest();
                displayLocation();

            }
        }

    }

    private void displayLocation() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null) {

            // create latlng

            LatLng center = new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude());

            LatLng northside = SphericalUtil.computeOffset(center,150000,0);
            LatLng southside = SphericalUtil.computeOffset(center,150000,180);

            LatLngBounds bounds = LatLngBounds.builder().include(northside).include(southside).build();

            place_location.setBoundsBias(bounds);
            place_location.setFilter(typefilter);




            driversAvailable = FirebaseDatabase.getInstance().getReference(Common.drivers);

            driversAvailable.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    loadAllAvailableDriver(new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude()));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            final double latitude = mLastLocation.getLatitude();
            final double longitude = mLastLocation.getLongitude();
            //Update to firebase
            //Add marker
            if (mUserMarker != null)
                mUserMarker.remove(); //remove already marker

            mUserMarker = mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(latitude, longitude))
                    .title("Driver"));

            //move camera to this position
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 15.0f));
            loadAllAvailableDriver(new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude()));
            Log.d("ERROR",String.format("your location was changed: %f / %f",latitude,longitude));
        }
        else
        {
            Log.d("ERROR", "cannot display Location ");
        }
    }

    private void loadAllAvailableDriver(final LatLng location) {

        //delete all the marker first

        mMap.clear();

        // now again update you current location

        mMap.addMarker(new MarkerOptions().position(location).title("you"));


        //load all available drivers
        DatabaseReference driverLocation = FirebaseDatabase.getInstance().getReference(Common.drivers);
        GeoFire gf = new GeoFire(driverLocation);

        GeoQuery geoQuery = gf.queryAtLocation(new GeoLocation(location.latitude,location.longitude),distance);
        geoQuery.removeAllListeners();

        geoQuery.addGeoQueryEventListener(new GeoQueryEventListener() {
            @Override
            public void onKeyEntered(String key, final GeoLocation location) {
                FirebaseDatabase.getInstance().getReference(Common.user_drivers).child(key).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Rider rider = dataSnapshot.getValue(Rider.class);


                        //add driver on map
                        mMap.addMarker(new MarkerOptions().position(new LatLng(location.latitude,location.longitude))
                                .flat(true).title(rider.getName()).snippet("Phone:"+ rider.getPhone())
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.amb)));
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }

            @Override
            public void onKeyExited(String key) {

            }

            @Override
            public void onKeyMoved(String key, GeoLocation location) {

            }

            @Override
            public void onGeoQueryReady() {
                if (distance <= LIMIT)
                {
                    distance++;
                    loadAllAvailableDriver(location);
                }
            }

            @Override
            public void onGeoQueryError(DatabaseError error) {

            }
        });

    }

    private void createLocationRequest() {
        mLocationRequest=new LocationRequest();
        mLocationRequest.setInterval(UPDATE_INTERVAL);
        mLocationRequest.setFastestInterval(FATEST_INTERVAL);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setSmallestDisplacement(DISPLACEMENT);

    }

    private void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable( this);
        if(resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode))
                GooglePlayServicesUtil.getErrorDialog(resultCode, this, PLAY_SERVICE_RES_REQUEST).show();
            else {
                Toast.makeText(this, "this device is not supported", Toast.LENGTH_SHORT).show();

            }
            return  false;
        }
        return true;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Profile) {

            Intent intent = new Intent(this, Profile.class);

            startActivity(intent);

        } else if (id == R.id.nav_First_aids) {

            Intent intent = new Intent(this, Firstaids.class);

            startActivity(intent);
        }
        else if (id == R.id.nav_nearBy) {
            Intent intent = new Intent(this, Notifications.class);
            startActivity(intent);

        } else if (id == R.id.nav_Rating) {

            Intent intent = new Intent(this, Rating.class);

            startActivity(intent);
        }
        else if (id == R.id.nav_blood) {
            Intent intent = new Intent(this, bloodGroup.class);

            startActivity(intent);

        }
        else if (id == R.id.nav_ContactUs) {
            Intent intent = new Intent(this, Contactus.class);

            startActivity(intent);

        } else if (id == R.id.nav_Services) {
            Intent intent = new Intent(this, Services.class);

            startActivity(intent);
        }
        else if (id == R.id.nav_MLO) {

            Intent intent = new Intent(this,MLO.class);

            startActivity(intent);
        }else if (id == R.id.nav_logout) {

            Paper.init(this);

            Paper.book().destroy();

            FirebaseAuth.getInstance().signOut();

            Intent intent = new Intent(this,MainActivity.class);

            startActivity(intent);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.setInfoWindowAdapter(new CustomInfoWindow(this));
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        displayLocation();
        startLocationUpdates();
    }

    private void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }

        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);

    }

    @Override
    public void onConnectionSuspended(int i) {
        mGoogleApiClient.connect();


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation=location;
        displayLocation();

    }}