package getresult.example.asus.nottspark;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment implements OnMapReadyCallback, View.OnClickListener {


    public MapFragment() {
        // Required empty public constructor
    }

    private Button mbtnLeaver;
    private Button mbtnParker;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.maps_fragment, container, false);

        mbtnLeaver = (Button) v.findViewById(R.id.btnLeaver);
        mbtnLeaver.setOnClickListener(this);
        mbtnParker = (Button) v.findViewById(R.id.btnParker);
        mbtnParker.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btnParker:
                intent = new Intent(getActivity(), Parker.class);
                break;
            case R.id.btnLeaver:
                intent = new Intent(getActivity(), Leaver.class);
                break;
        }

        if (intent != null)
            startActivity(intent);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng marker = new LatLng(2.9452538, 101.87471299999993);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 25));
        googleMap.addMarker(new MarkerOptions().title(("UNMC")).position(marker));

    }
}