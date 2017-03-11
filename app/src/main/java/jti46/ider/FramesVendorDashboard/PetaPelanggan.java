package jti46.ider.FramesVendorDashboard;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import jti46.ider.R;

public class PetaPelanggan extends Fragment implements OnMapReadyCallback {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private GoogleMap mMap;
    private static Context mContext;

    public PetaPelanggan(Context context) {
        mContext = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView =  inflater.inflate(R.layout.fragment_peta_pelanggan, container, false);
        SupportMapFragment mapFragment = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapPelanggan));
//        mapFragment.getMapAsync((OnMapReadyCallback) mContext);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                if (googleMap != null) {
                    mMap = googleMap;

                    // Add a marker in Sydney and move the camera
                    LatLng sydney = new LatLng(-7.9797, 112.6304);
                    mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Malang"));
//                    mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

                    CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(15.0f).build();
                    CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
                    googleMap.moveCamera(cameraUpdate);
                }
            }
        });
        return mView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
