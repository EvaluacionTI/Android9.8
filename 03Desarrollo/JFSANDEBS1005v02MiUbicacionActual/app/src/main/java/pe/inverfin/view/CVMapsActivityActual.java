package pe.inverfin.view;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.sql.Connection;

public class CVMapsActivityActual extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
/*    private Marker moMarcador;
    private double dLongitud;
    private double dLatitud;*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvmaps_actual);

        int iStatus = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());

        if (iStatus==ConnectionResult.SUCCESS){
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

        }else{
            Dialog oDialog = GooglePlayServicesUtil.getErrorDialog(iStatus,(Activity)getApplicationContext(),10);
            oDialog.show();
        }




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

        // Add a marker in Sydney and move the camera
/*        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/

        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        UiSettings oUISettings = mMap.getUiSettings();
        oUISettings.setZoomControlsEnabled(true);

        LatLng sydney = new LatLng(-63.049092, -60.958994);
        mMap.addMarker(new MarkerOptions().position(sydney).title("AD en Ubicación").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));

        float fZoomLevel = 16;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, fZoomLevel));
    }

/*    private void agregarMarcardor(double pdLongitud, double pdLatitud) {
        LatLng coordenadas = new LatLng(pdLatitud, pdLongitud);
        CameraUpdate miUbicacion = CameraUpdateFactory.newLatLngZoom(coordenadas, 16);
        if (moMarcador != null) {
            moMarcador.remove();
        }
        moMarcador = mMap.addMarker(new MarkerOptions()
                .position(coordenadas)
                .title("Mi posición actual : ")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher))
        );
        mMap.animateCamera(miUbicacion);
    }

    private void actualizarUbicacion(Location poLocalizacion) {
        if (poLocalizacion != null) {
            dLatitud = poLocalizacion.getLatitude();
            dLongitud = poLocalizacion.getLongitude();
            agregarMarcardor(dLongitud, dLatitud);
        }
    }*/

  /*  LocationListener locListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            actualizarUbicacion(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

    private void miUbicacion() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

            return;
        }

        LocationManager oLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location oLocation = oLocationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        actualizarUbicacion(oLocation);
        oLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,15000,0,locListener);
    }*/
}
