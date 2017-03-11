package jti46.ider;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import jti46.ider.engine.UtilityHelper;
import jti46.ider.engine.Vendor;
import jti46.ider.engine.VendorListAdapter;

public class UserDashboardActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener, VendorListAdapter.VendorListAdapterActionListener, OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private static final String TAB_LIST_TITLE = "DAFTAR";
    private static final String TAB_LOCATION_TITLE = "LOKASI";

    private Bundle appBundle;

    private TabHost tbhMain;
    private LinearLayout lnrTabList;
    private LinearLayout lnrTabLocation;
    private Spinner spnrCategories;
    private ListView lstVendors;

    private GoogleMap googleMap;
    private MapView mapVendorLocations;

    // Others
    private LocationManager locationManager;
    private Marker currentMarker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        this.appBundle = savedInstanceState;

        this.initComponents();
    }

    private void initComponents() {
        this.tbhMain = (TabHost) this.findViewById(R.id.tbh_main);
        this.lnrTabList = (LinearLayout) this.findViewById(R.id.lnr_tab_list);
        this.lnrTabLocation = (LinearLayout) this.findViewById(R.id.lnr_tab_location);
        this.spnrCategories = (Spinner) this.findViewById(R.id.spnr_categories);
        this.lstVendors = (ListView) this.findViewById(R.id.lst_vendors);
        this.mapVendorLocations = (MapView) this.findViewById(R.id.map_vendor_locations);

        this.setupMap();
        this.setupListView();
        this.setupSpinner();
        this.setupTabs();
    }

    private void setupMap() {
        // Setup MapView
        this.mapVendorLocations.onCreate(this.appBundle);
        this.mapVendorLocations.getMapAsync(this);
    }

    private void setupListView() {
        VendorListAdapter adapter = new VendorListAdapter(this, this.vendorList());

        this.lstVendors.setAdapter(adapter);

        this.lstVendors.setOnItemClickListener(this);
    }

    private void setupSpinner() {
        ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, this.categoryList());

        this.spnrCategories.setAdapter(categoriesAdapter);
    }

    private void setupTabs() {
        this.tbhMain.setup();

        TabHost.TabSpec listSpec = this.tbhMain.newTabSpec(UserDashboardActivity.TAB_LIST_TITLE);
        listSpec.setContent(R.id.lnr_tab_list);
        listSpec.setIndicator(UserDashboardActivity.TAB_LIST_TITLE);

        TabHost.TabSpec locationSpec = this.tbhMain.newTabSpec(UserDashboardActivity.TAB_LOCATION_TITLE);
        locationSpec.setContent(R.id.lnr_tab_location);
        locationSpec.setIndicator(UserDashboardActivity.TAB_LOCATION_TITLE);

        this.tbhMain.addTab(listSpec);
        this.tbhMain.addTab(locationSpec);
    }

    private ArrayList<String> categoryList() {
        ArrayList<String> categories = new ArrayList<>();

        categories.add("Semua");
        categories.add("Bakso");
        categories.add("Sate");
        categories.add("Siomay");
        categories.add("Tahu Tek");
        categories.add("Nasi Goreng");
        categories.add("Tahu Telor");

        return categories;
    }

    private ArrayList<Vendor> vendorList() {
        ArrayList<Vendor> vendors = new ArrayList<>();

        vendors.add(new Vendor(1, "cakkhoir87", "Bakso", "Cakman Khoiri", "Bakso enak murah mantap nikmat", "Jl. Tombro", 600));
        vendors.add(new Vendor(2, "siomaymantap", "Siomay", "Cak Mantap", "Ayo siomaynya...", "Jl. Mujair", 233));
        vendors.add(new Vendor(3, "sateoke99", "Sate", "Cak Mandra", "Monggo satenipun diskon 50%", "Jl. Tombro", 800));

        return vendors;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void OnPengenButtonClicked(Vendor selectedVendor) {
        Intent i = new Intent(this, MapsActivity.class);

        this.startActivity(i);
    }

    @Override
    public void OnPesenButtonClicked(Vendor selectedVendor) {
        Intent i = new Intent(this, VendorDetailActivity.class);

        this.startActivity(i);
    }

    private boolean checkLocationAccessPermission() {
        boolean fineLocationGranted = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        boolean coarseLocationGranted = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;

        boolean allIsGranted = fineLocationGranted && coarseLocationGranted;

        return allIsGranted;
    }

    private LatLng currentPosition() {
        LatLng position = null;

        if (this.locationManager == null)
            this.locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);

        if (this.checkLocationAccessPermission()) {
            Location location = this.locationManager.getLastKnownLocation(
                    LocationManager.NETWORK_PROVIDER);

            if (location != null) {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();

                position = new LatLng(latitude, longitude);
            }
        }

        //UtilityHelper.showAlert(this, "Warning", "Location permission is not granted. " +
        //        "Please enable it via settings page");

        UtilityHelper.loge("Location permission is not currently granted. " +
                "Please enable it via settings page");

        return position;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        this.googleMap.setOnMapClickListener(this);

        this.googleMap.getUiSettings().setScrollGesturesEnabled(true);
        this.googleMap.getUiSettings().setZoomControlsEnabled(true);

        LatLng position = this.currentPosition();

        if (position == null)
            position = new LatLng(21, 57);

        this.zoomToPosition(position);

        this.currentMarker = this.addMarker(position, "You are here");
    }

    private void zoomToPosition(LatLng position) {
        float zoomLevel = 12.0f;
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(position, zoomLevel);

        this.googleMap.moveCamera(cameraUpdate);
    }

    private Marker addMarker(LatLng position, String title) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(position);

        if (title != null)
            markerOptions.title(title);

        Marker marker = this.googleMap.addMarker(markerOptions);

        return marker;
    }

    @Override
    public void onMapClick(LatLng latLng) {
        if (this.currentMarker != null)
            this.currentMarker.remove();

        this.currentMarker = this.addMarker(latLng, "Add Place Here..");

        double latitude = latLng.latitude;
        double longitude = latLng.longitude;

        UtilityHelper.logi("Lat: " + latitude + "; Long: " + longitude);
    }
}
