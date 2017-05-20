package com.example.gaby.turistear;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
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

//PAQUETES PARA STREET VIEW
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static android.R.attr.data;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, DirectionFinderListener {

    private GoogleMap mMap;
    private Marker marcadorPosicionActual;
    private Marker marcadorAeropuerto;
    private MarkerOptions marcadorBanco1;
    private Marker marcadorBanco2;
    private Marker marcadorBanco3;
    private Marker marcadorBanco4;
    private Marker marcadorBanco5;
    private Marker marcadorBanco6;
    private Marker marcadorBanco7;
    private Marker marcadorBanco8;
    private Marker marcadorBanco9;
    private Marker marcadorBanco10;
    private MarkerOptions marcadorBar1;
    private Marker marcadorBar2;
    private Marker marcadorBar3;
    private Marker marcadorBar4;
    private Marker marcadorBar5;
    private Marker marcadorBar6;
    private Marker marcadorBar7;
    private Marker marcadorBar8;
    private Marker marcadorBar9;
    private Marker marcadorBar10;
    private Marker marcadorCementerio1;
    private Marker marcadorCementerio2;
    private Marker marcadorCine1;
    private Marker marcadorCine2;
    private MarkerOptions marcadorFarmacia1;
    private Marker marcadorFarmacia2;
    private Marker marcadorFarmacia3;
    private Marker marcadorFarmacia4;
    private Marker marcadorFarmacia5;
    private Marker marcadorFarmacia6;
    private Marker marcadorFarmacia7;
    private Marker marcadorFarmacia8;
    private Marker marcadorFarmacia9;
    private Marker marcadorFarmacia10;
    private MarkerOptions marcadorHospital1;
    private Marker marcadorHospital2;
    private Marker marcadorHospital3;
    private Marker marcadorHospital4;
    private Marker marcadorHospital5;
    private Marker marcadorHospital6;
    private Marker marcadorHospital7;
    private Marker marcadorHospital8;
    private Marker marcadorHospital9;
    private Marker marcadorHospital10;
    private MarkerOptions marcadorHotel1;
    private Marker marcadorHotel2;
    private Marker marcadorHotel3;
    private Marker marcadorHotel4;
    private Marker marcadorHotel5;
    private Marker marcadorHotel6;
    private Marker marcadorHotel7;
    private Marker marcadorHotel8;
    private Marker marcadorHotel9;
    private Marker marcadorHotel10;
    private MarkerOptions marcadorMuseo1;
    private Marker marcadorMuseo2;
    private Marker marcadorMuseo3;
    private Marker marcadorMuseo4;
    private Marker marcadorMuseo5;
    private Marker marcadorMuseo6;
    private Marker marcadorMuseo7;
    private Marker marcadorMuseo8;
    private Marker marcadorMuseo9;
    private Marker marcadorMuseo10;
    private MarkerOptions marcadorParque1;
    private Marker marcadorParque2;
    private Marker marcadorParque3;
    private Marker marcadorParque4;
    private Marker marcadorParque5;
    private Marker marcadorParque6;
    private Marker marcadorParque7;
    private Marker marcadorParque8;
    private Marker marcadorParque9;
    private Marker marcadorParque10;
    private MarkerOptions marcadorRestaurante1;
    private Marker marcadorRestaurante2;
    private Marker marcadorRestaurante3;
    private Marker marcadorRestaurante4;
    private Marker marcadorRestaurante5;
    private Marker marcadorRestaurante6;
    private Marker marcadorRestaurante7;
    private Marker marcadorRestaurante8;
    private Marker marcadorRestaurante9;
    private Marker marcadorRestaurante10;
    private MarkerOptions marcadorTeatro1;
    private Marker marcadorTeatro2;
    private Marker marcadorTeatro3;
    private MarkerOptions marcadorUniversidad1;
    private Marker marcadorUniversidad2;
    private Marker marcadorUniversidad3;
    LatLng coordenadas;
    double lat = 0.0;
    double lng = 0.0;
    double latStreet=0.0;
    double longStreet=0.0;
    int cont=-1;
    Integer tipo=1;
    String mapa;
    String nombre;
    Button btnMapa;
    Button btnHome;
    private final static int MY_PERMISSION_FINE_LOCATION=101;
    String[] categorias = new String[13] ;

    //para el street view
    Switch switchSalirStreetView;

    //para los botones
    FloatingActionMenu materialDesignFAM;
    FloatingActionButton botonFlotanteStreetView, botonFlotanteRuta;

    //para las rutas
    private List<Marker> originMarkers = new ArrayList<>();
    private List<Marker> destinationMarkers = new ArrayList<>();
    private List<Polyline> polylinePaths = new ArrayList<>();
    private ProgressDialog progressDialog;
    int vaRutas=0;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext());
        if (status == ConnectionResult.SUCCESS) {

            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);
            btnMapa=(Button)findViewById(R.id.btnMapa);
            btnHome=(Button)findViewById(R.id.btnHome);
            btnMapa.setOnClickListener(new View.OnClickListener(){

                //sirve para los diferentes tipos de mapa
                public void onClick(View view){

                    switch (tipo){
                        case 1: mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                            mapa="MAPA HIBRIDO";
                            tipo=2;
                            break;
                        case 2: mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                            mapa="MAPA SATELITE";
                            tipo=3;
                            break;
                        case 3: mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                            mapa="MAPA TERRENO";
                            tipo=4;
                            break;
                        case 4: mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                            mapa="MAPA NORMAL";
                            tipo=1;
                            break;
                    }
                    Toast toast=Toast.makeText(getApplicationContext(),mapa,Toast.LENGTH_SHORT);
                    toast .show();
                }
            });

            //BOTON HOME: MANDA DEL MAPA A LA PANTALLA PRINCIPAL
            btnHome.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View arg0){
                    borrarCategoriasHome();
                    Intent inten = new Intent(MapsActivity.this,MainActivity.class);
                    startActivity(inten);

                }
            });


        } else {

            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, (Activity) getApplicationContext(), 10);
            dialog.show();
        }

        //BOTONES FLOTANTES
        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.social_floating_menu);

    }

    public void borrarCategoriasHome(){


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        clickMarcador();

        UiSettings uiSettings=mMap.getUiSettings();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        uiSettings.setMapToolbarEnabled(true);
        uiSettings.setCompassEnabled(true);
        //float zoomCuenca=12;
        miUbicacion(); //sirve para poner un marcador y tener las coordenadas
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(coordenadas,zoomCuenca));
        agregarMarcador();
    }

    public void clickMarcador(){

        botonFlotanteStreetView = (FloatingActionButton) findViewById(R.id.verStreetView);
        botonFlotanteRuta = (FloatingActionButton) findViewById(R.id.trazarRuta);
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker marker) {
                LatLng ll = marker.getPosition();
                latStreet=ll.latitude;
                longStreet=ll.longitude;
                botonFlotanteStreetView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        streetView();
                    }
                });

                botonFlotanteRuta.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        //TODO something when floating action menu second item clicked
                        Toast.makeText(getApplicationContext(),"entro boton",Toast.LENGTH_SHORT).show();
                        sendRequest();

                    }
                });
                return false;


            }
        });

    }

    private void sendRequest() {
        String origin="";
        if(vaRutas==0){
            origin = lat+","+lng;
            vaRutas++;
        }
        String destination = latStreet+","+longStreet;
        //aqui mando de donde a donde quiero ir
        try {
            new DirectionFinder(this, origin, destination).execute();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            origin = destination;

        }

    }

    public void streetView(){

        setContentView(R.layout.activity_street_view);


        switchSalirStreetView = (Switch)findViewById(R.id.switchSalir);
        switchSalirStreetView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(switchSalirStreetView.isChecked()){
                    //Toast.makeText(getApplicationContext(),"pulsaste ",Toast.LENGTH_SHORT).show();
                    Intent inten = new Intent(MapsActivity.this,MapsActivity.class);
                    startActivity(inten);
                }
            }
        });

        SupportStreetViewPanoramaFragment streetViewPanoramaFragment =
                (SupportStreetViewPanoramaFragment)
                        getSupportFragmentManager().findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(
                new OnStreetViewPanoramaReadyCallback() {
                    @Override
                    public void onStreetViewPanoramaReady(StreetViewPanorama panorama) {
                        LatLng ubicacion= new LatLng(latStreet, longStreet);
                        panorama.setPosition(ubicacion);
                    }
                });
    }

    /*public void abrirVentana(){
        //es para poner la ventana de latitud y longitud
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }
            @Override
            public View getInfoContents(Marker marker) {
                View v = getLayoutInflater().inflate(R.layout.info_window,null);
                TextView latitud = (TextView)v.findViewById(R.id.tvLat);
                TextView longitud = (TextView)v.findViewById(R.id.tvLng);
                TextView texto = (TextView)v.findViewById(R.id.tvText);
                Button street = (Button)v.findViewById(R.id.streetView);
                LatLng ll = marker.getPosition();
                String nuevo = "Latitud: "+ll.latitude;
                String nuevo1 = "Longitud: "+ll.longitude;
                //String nuevo2 = "Mi posicion Actual";
                latitud.setText(nuevo);
                longitud.setText(nuevo1);
                texto.setText(nombre);
                street.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View arg0){
                        Toast.makeText(getApplicationContext(),"entro ",Toast.LENGTH_SHORT).show();
                        Intent inten = new Intent(MapsActivity.this,StreetView.class);
                        startActivity(inten);
                    }
                });
                return v;
            }
        });
    }*/

    public void marcadorGPS(double lat, double lng){

        coordenadas = new LatLng(lat,lng);
        CameraUpdate miUbicacion = CameraUpdateFactory.newLatLngZoom(coordenadas, 16);

        //MARCADOR DE MI POSICION ACTUAL
        if (marcadorPosicionActual != null) marcadorPosicionActual.remove();
        marcadorPosicionActual = mMap.addMarker(new MarkerOptions().
                position(coordenadas).title("Mi Posicion Actual").
                icon(BitmapDescriptorFactory.fromResource(R.mipmap.pin1)));
    }


    public void llenarCategorias(String[] args1){

        final AyudaBD ayudabd = new AyudaBD(getApplicationContext());
        SQLiteDatabase db = ayudabd.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Tabla Where nombre=? ",args1);
        if(c.moveToFirst()){
            //Toast.makeText(getApplicationContext(),"entro" ,Toast.LENGTH_SHORT).show();
            do{
                //Toast.makeText(getApplicationContext(),"cate "+c.getString(4) ,Toast.LENGTH_SHORT).show();
                cont++;
                categorias[cont]=c.getString(4);
            }while(c.moveToNext());
        }
    }

    public void agregarMarcador() {

        String latitud="", longitud="", nombre="", a="", lugar="";
        String[] args1 = new String[] {"opc1"};
        llenarCategorias(args1);
        String[] args2 = new String[] {"opc2"};
        llenarCategorias(args2);
        String[] args3 = new String[] {"opc3"};
        llenarCategorias(args3);
        String[] args4 = new String[] {"opc4"};
        llenarCategorias(args4);
        String[] args5 = new String[] {"opc5"};
        llenarCategorias(args5);
        String[] args6 = new String[] {"opc6"};
        llenarCategorias(args6);
        String[] args7 = new String[] {"opc7"};
        llenarCategorias(args7);
        String[] args8 = new String[] {"opc8"};
        llenarCategorias(args8);
        String[] args9 = new String[] {"opc9"};
        llenarCategorias(args9);
        String[] args10 = new String[] {"opc10"};
        llenarCategorias(args10);
        String[] args11 = new String[] {"opc11"};
        llenarCategorias(args11);
        String[] args12 = new String[] {"opc12"};
        llenarCategorias(args12);
        String[] args13 = new String[] {"opc13"};
        llenarCategorias(args13);
        List<MarkerOptions> listaMarcadoresBancos = new ArrayList<MarkerOptions>();
        List<MarkerOptions> listaMarcadoresBares = new ArrayList<MarkerOptions>();
        List<MarkerOptions> listaMarcadoresFarmacias = new ArrayList<MarkerOptions>();
        List<MarkerOptions> listaMarcadoresHospitales = new ArrayList<MarkerOptions>();
        List<MarkerOptions> listaMarcadoresHoteles = new ArrayList<MarkerOptions>();
        List<MarkerOptions> listaMarcadoresMuseos = new ArrayList<MarkerOptions>();
        List<MarkerOptions> listaMarcadoresParques = new ArrayList<MarkerOptions>();
        List<MarkerOptions> listaMarcadoresRestaurantes = new ArrayList<MarkerOptions>();
        List<MarkerOptions> listaMarcadoresTeatros = new ArrayList<MarkerOptions>();
        List<MarkerOptions> listaMarcadoresUniversidades = new ArrayList<MarkerOptions>();

        final AyudaBD ayudabd = new AyudaBD(getApplicationContext());
        SQLiteDatabase db = ayudabd.getWritableDatabase();
        for(int i=0; i<=cont; i++){
            a=categorias[i];
            //Toast.makeText(getApplicationContext(),"vale "+a,Toast.LENGTH_SHORT).show();
            if(a!=null){
                switch(a){
                    case "aeropuerto":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Aeropuerto"};
                        Cursor c = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        if(c.moveToFirst()){
                            do{
                                nombre = c.getString(1);
                                latitud = c.getString(2);
                                longitud = c.getString(3);
                                //Toast.makeText(getApplicationContext(),"nombre " +nombre,Toast.LENGTH_SHORT).show();
                            }while(c.moveToNext());
                        }
                        double lat1 = 0.0;
                        double lng1 = 0.0;
                        lat1 = Float.parseFloat(latitud);
                        lng1 = Float.parseFloat(longitud);
                        LatLng mAeropuerto = new LatLng(lat1, lng1);
                        if (marcadorAeropuerto != null) marcadorAeropuerto.remove();
                        marcadorAeropuerto = mMap.addMarker(new MarkerOptions().
                                position(mAeropuerto).title(nombre).
                                icon(BitmapDescriptorFactory.fromResource(R.mipmap.aeropuerto1)));
                        break;

                    case "banco":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Banco"};
                        Cursor c1 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        int num=0;
                        if(c1.moveToFirst()){
                            do{
                                nombre = c1.getString(1);
                                latitud = c1.getString(2);
                                longitud = c1.getString(3);
                                double lat2 = 0.0;
                                double lng2 = 0.0;
                                lat2 = Float.parseFloat(latitud);
                                lng2 = Float.parseFloat(longitud);
                                LatLng mBanco = new LatLng(lat2, lng2);
                                marcadorBanco1 = new MarkerOptions().
                                        position(mBanco).title(nombre).
                                        icon(BitmapDescriptorFactory.fromResource(R.mipmap.banco1));
                                listaMarcadoresBancos.add(marcadorBanco1);
                            }while(c1.moveToNext());
                        }
                        Iterator iter = listaMarcadoresBancos.iterator();
                        while(iter.hasNext()){
                            mMap.addMarker((MarkerOptions) iter.next());
                        }
                        break;

                    case "bar":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Bar-Discoteca"};
                        Cursor c2 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c2.moveToFirst()){
                            do{
                                num++;
                                nombre = c2.getString(1);
                                latitud = c2.getString(2);
                                longitud = c2.getString(3);
                                double lat3 = 0.0;
                                double lng3 = 0.0;
                                lat3 = Float.parseFloat(latitud);
                                lng3 = Float.parseFloat(longitud);
                                LatLng mBanco = new LatLng(lat3, lng3);
                                marcadorBar1 = new MarkerOptions().
                                        position(mBanco).title(nombre).
                                        icon(BitmapDescriptorFactory.fromResource(R.mipmap.bar1));
                                listaMarcadoresBares.add(marcadorBar1);
                            }while(c2.moveToNext());
                        }
                        Iterator iterBares = listaMarcadoresBares.iterator();
                        while(iterBares.hasNext()){
                            mMap.addMarker((MarkerOptions) iterBares.next());
                        }
                        break;

                    case "cementerio":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Cementerio"};
                        Cursor c3 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c3.moveToFirst()){
                            do{
                                num++;
                                nombre = c3.getString(1);
                                latitud = c3.getString(2);
                                longitud = c3.getString(3);
                                double lat4 = 0.0;
                                double lng4 = 0.0;
                                lat4 = Float.parseFloat(latitud);
                                lng4 = Float.parseFloat(longitud);
                                if(num==0){
                                    LatLng mBanco = new LatLng(lat4, lng4);
                                    if (marcadorCementerio1 != null) marcadorCementerio1.remove();
                                    marcadorCementerio1 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.cementerio1)));
                                }else{
                                    LatLng mBanco = new LatLng(lat4, lng4);
                                    if (marcadorCementerio2 != null) marcadorCementerio2.remove();
                                    marcadorCementerio2 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.cementerio1)));
                                }
                            }while(c3.moveToNext());
                        }
                        break;

                    case "cine":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Cine"};
                        Cursor c4 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c4.moveToFirst()){
                            do{
                                num++;
                                nombre = c4.getString(1);
                                latitud = c4.getString(2);
                                longitud = c4.getString(3);
                                double lat5 = 0.0;
                                double lng5 = 0.0;
                                lat5 = Float.parseFloat(latitud);
                                lng5 = Float.parseFloat(longitud);
                                if(num==0){
                                    LatLng mBanco = new LatLng(lat5, lng5);
                                    if (marcadorCine1 != null) marcadorCine1.remove();
                                    marcadorCine1 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.cine1)));
                                }else{
                                    LatLng mBanco = new LatLng(lat5, lng5);
                                    if (marcadorCine2 != null) marcadorCine2.remove();
                                    marcadorCine2 = mMap.addMarker(new MarkerOptions().
                                            position(mBanco).title(nombre).
                                            icon(BitmapDescriptorFactory.fromResource(R.mipmap.cine1)));
                                }
                            }while(c4.moveToNext());
                        }
                        break;

                    case "farmacia":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Farmacia"};
                        Cursor c5 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c5.moveToFirst()){
                            do{
                                num++;
                                nombre = c5.getString(1);
                                latitud = c5.getString(2);
                                longitud = c5.getString(3);
                                double lat6 = 0.0;
                                double lng6 = 0.0;
                                lat6 = Float.parseFloat(latitud);
                                lng6 = Float.parseFloat(longitud);
                                LatLng mBanco = new LatLng(lat6, lng6);
                                marcadorFarmacia1 = new MarkerOptions().
                                        position(mBanco).title(nombre).
                                        icon(BitmapDescriptorFactory.fromResource(R.mipmap.farmacia1));
                                listaMarcadoresFarmacias.add(marcadorFarmacia1);
                            }while(c5.moveToNext());
                        }
                        Iterator iterFarmacias = listaMarcadoresFarmacias.iterator();
                        while(iterFarmacias.hasNext()){
                            mMap.addMarker((MarkerOptions) iterFarmacias.next());
                        }
                        break;

                    case "hospital":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Hospital"};
                        Cursor c6 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c6.moveToFirst()){
                            do{
                                num++;
                                nombre = c6.getString(1);
                                latitud = c6.getString(2);
                                longitud = c6.getString(3);
                                double lat7 = 0.0;
                                double lng7 = 0.0;
                                lat7 = Float.parseFloat(latitud);
                                lng7 = Float.parseFloat(longitud);
                                LatLng mBanco = new LatLng(lat7, lng7);
                                marcadorHospital1 = new MarkerOptions().
                                        position(mBanco).title(nombre).
                                        icon(BitmapDescriptorFactory.fromResource(R.mipmap.hospital1));
                                listaMarcadoresHospitales.add(marcadorHospital1);
                            }while(c6.moveToNext());
                        }
                        Iterator iterHospitales = listaMarcadoresHospitales.iterator();
                        while(iterHospitales.hasNext()){
                            mMap.addMarker((MarkerOptions) iterHospitales.next());
                        }
                        break;


                    case "hotel":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Hotel"};
                        Cursor c7 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c7.moveToFirst()){
                            do{
                                num++;
                                nombre = c7.getString(1);
                                latitud = c7.getString(2);
                                longitud = c7.getString(3);
                                double lat8 = 0.0;
                                double lng8 = 0.0;
                                lat8 = Float.parseFloat(latitud);
                                lng8 = Float.parseFloat(longitud);
                                LatLng mBanco = new LatLng(lat8, lng8);
                                marcadorHotel1 = new MarkerOptions().
                                        position(mBanco).title(nombre).
                                        icon(BitmapDescriptorFactory.fromResource(R.mipmap.hotel1));
                                listaMarcadoresHoteles.add(marcadorHotel1);
                            }while(c7.moveToNext());
                        }
                        Iterator iterHoteles = listaMarcadoresHoteles.iterator();
                        while(iterHoteles.hasNext()){
                            mMap.addMarker((MarkerOptions) iterHoteles.next());
                        }
                        break;

                    case "museo":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Museo"};
                        Cursor c8 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c8.moveToFirst()){
                            do{
                                num++;
                                nombre = c8.getString(1);
                                latitud = c8.getString(2);
                                longitud = c8.getString(3);
                                double lat9 = 0.0;
                                double lng9 = 0.0;
                                lat9 = Float.parseFloat(latitud);
                                lng9 = Float.parseFloat(longitud);
                                LatLng mBanco = new LatLng(lat9, lng9);
                                marcadorMuseo1 = new MarkerOptions().
                                        position(mBanco).title(nombre).
                                        icon(BitmapDescriptorFactory.fromResource(R.mipmap.museo1));
                                listaMarcadoresMuseos.add(marcadorMuseo1);
                            }while(c8.moveToNext());
                        }
                        Iterator iterMuseos = listaMarcadoresMuseos.iterator();
                        while(iterMuseos.hasNext()){
                            mMap.addMarker((MarkerOptions) iterMuseos.next());
                        }
                        break;

                    case "parque":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Parque"};
                        Cursor c9 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c9.moveToFirst()){
                            do{
                                num++;
                                nombre = c9.getString(1);
                                latitud = c9.getString(2);
                                longitud = c9.getString(3);
                                double lat10 = 0.0;
                                double lng10 = 0.0;
                                lat10 = Float.parseFloat(latitud);
                                lng10 = Float.parseFloat(longitud);
                                LatLng mBanco = new LatLng(lat10, lng10);
                                marcadorParque1 = new MarkerOptions().
                                        position(mBanco).title(nombre).
                                        icon(BitmapDescriptorFactory.fromResource(R.mipmap.parque1));
                                listaMarcadoresParques.add(marcadorParque1);
                            }while(c9.moveToNext());
                        }
                        Iterator iterParques = listaMarcadoresParques.iterator();
                        while(iterParques.hasNext()){
                            mMap.addMarker((MarkerOptions) iterParques.next());
                        }
                        break;

                    case "restaurante":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Restaurante"};
                        Cursor c10 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c10.moveToFirst()){
                            do{
                                num++;
                                nombre = c10.getString(1);
                                latitud = c10.getString(2);
                                longitud = c10.getString(3);
                                double lat11 = 0.0;
                                double lng11 = 0.0;
                                lat11 = Float.parseFloat(latitud);
                                lng11 = Float.parseFloat(longitud);
                                LatLng mBanco = new LatLng(lat11, lng11);
                                marcadorRestaurante1 = new MarkerOptions().
                                        position(mBanco).title(nombre).
                                        icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante1));
                                listaMarcadoresRestaurantes.add(marcadorRestaurante1);
                            }while(c10.moveToNext());
                        }
                        Iterator iterRestaurantes = listaMarcadoresRestaurantes.iterator();
                        while(iterRestaurantes.hasNext()){
                            mMap.addMarker((MarkerOptions) iterRestaurantes.next());
                        }
                        break;

                    case "teatro":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Teatro"};
                        Cursor c11 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c11.moveToFirst()){
                            do{
                                num++;
                                nombre = c11.getString(1);
                                latitud = c11.getString(2);
                                longitud = c11.getString(3);
                                double lat12 = 0.0;
                                double lng12 = 0.0;
                                lat12 = Float.parseFloat(latitud);
                                lng12 = Float.parseFloat(longitud);
                                LatLng mBanco = new LatLng(lat12,lng12);
                                marcadorTeatro1 = new MarkerOptions().
                                        position(mBanco).title(nombre).
                                        icon(BitmapDescriptorFactory.fromResource(R.mipmap.teatro1));
                                listaMarcadoresTeatros.add(marcadorTeatro1);
                            }while(c11.moveToNext());
                        }
                        Iterator iterTeatro = listaMarcadoresTeatros.iterator();
                        while(iterTeatro.hasNext()){
                            mMap.addMarker((MarkerOptions) iterTeatro.next());
                        }
                        break;

                    case "universidad":
                        //Toast.makeText(getApplicationContext(),"ENTRO "+a,Toast.LENGTH_SHORT).show();
                        args1 = new String[] {"Universidad"};
                        Cursor c12 = db.rawQuery("SELECT * FROM Tabla Where lugar=? ",args1);
                        num=-1;
                        if(c12.moveToFirst()){
                            do{
                                num++;
                                nombre = c12.getString(1);
                                latitud = c12.getString(2);
                                longitud = c12.getString(3);
                                double lat13 = 0.0;
                                double lng13 = 0.0;
                                lat13 = Float.parseFloat(latitud);
                                lng13 = Float.parseFloat(longitud);
                                LatLng mBanco = new LatLng(lat13, lng13);
                                marcadorUniversidad1 = new MarkerOptions().
                                        position(mBanco).title(nombre).
                                        icon(BitmapDescriptorFactory.fromResource(R.mipmap.universidad1));
                                listaMarcadoresUniversidades.add(marcadorUniversidad1);
                            }while(c12.moveToNext());
                        }
                        Iterator iterUniversidades = listaMarcadoresUniversidades.iterator();
                        while(iterUniversidades.hasNext()){
                            mMap.addMarker((MarkerOptions) iterUniversidades.next());
                        }
                        break;
                }
            }
        }
    }
    //public void agregarMarcador1(/*String lugar, String nombre, String latitud, String longitud*/) {

        /*String latitud="", longitud="", nombre="";
        SQLiteDatabase db = miBaseDatos.getWritableDatabase();
        String[] args = new String[] {"aeropuerto"};
        Cursor c = db.rawQuery(DatosTabla1.COLUMNA_LUGAR+"=?",args);
        /*if(c.moveToFirst()){
            do{
                nombre = c.getString(0);
                latitud = c.getString(1);
                longitud = c.getString(2);
                Toast.makeText(getApplicationContext(), ""+nombre+""+latitud+""+longitud, Toast.LENGTH_LONG).show();
            }while(c.moveToNext());
        }*/
    //lat = Integer.parseInt(latitud);
    //lng = Integer.parseInt(longitud);
        /*lat = Integer.parseInt(latitud);
        lng = Integer.parseInt(longitud);
        //Marcadores Aeropuerto
        if(lugar=="aeropuerto"){
            LatLng mAeropuerto = new LatLng(lat, lng);
            if (marcadorRestaurante != null) marcadorRestaurante.remove();
            marcadorRestaurante = mMap.addMarker(new MarkerOptions().
                    position(mAeropuerto).title(nombre).
                    icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante1)));
        }*/
        /*LatLng mRestaurante = new LatLng(lat, lng);
        if (marcadorRestaurante != null) marcadorRestaurante.remove();
        marcadorRestaurante = mMap.addMarker(new MarkerOptions().
                position(mRestaurante).title(nombre).
                icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante1)));
        /*LatLng mRestaurante2 = new LatLng(-2.900850321505161, -79.00559858825841);
        if (marcadorRestaurante2 != null) marcadorRestaurante2.remove();
        marcadorRestaurante2 = mMap.addMarker(new MarkerOptions().
                position(mRestaurante2).title("Restaurante").
                icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurante1)));*/

    //mMap.animateCamera(miUbicacion); //esto hace que de una se muestre donde esta de forma acercada*/
    //}

    //ESTE METODO SIRVE PARA OBTENER LA LATITUD Y LONGITUD DE NUESTRA POSICION ACTUAL
    private void actualizarUbicacion(Location location) {
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
            marcadorGPS(lat, lng);
            //agregarMarcador();
        }
    }

    LocationListener locListener = new LocationListener() {

        //RECIBE LA ACTUALIZACION DE LA LOCALIZACION DE LA POSICION
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
            return;
        }
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);//PBETENER SERVICIOS DE GEO POSICIONAMIENTO EN EL DISPOSITIVO
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER); //OBTENGO MI UTIMA POSICION CONOCIDA
        actualizarUbicacion(location);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,15000,0,locListener); //SOLICITO AL GPS ACTUALIZACION DE POSICION CADA 15 SEG.
    }

    @Override
    public void onDirectionFinderStart() {
        progressDialog = ProgressDialog.show(this, "Please wait.",
                "Finding direction..!", true);

        if (originMarkers != null) {
            for (Marker marker : originMarkers) {
                marker.remove();
            }
        }

        if (destinationMarkers != null) {
            for (Marker marker : destinationMarkers) {
                marker.remove();
            }
        }

        if (polylinePaths != null) {
            for (Polyline polyline:polylinePaths ) {
                polyline.remove();
            }
        }
    }

    //aqui hace toooodo
    @Override
    public void onDirectionFinderSuccess(List<Route> routes) {
        progressDialog.dismiss();
        polylinePaths = new ArrayList<>();
        originMarkers = new ArrayList<>();
        destinationMarkers = new ArrayList<>();

        for (Route route : routes) {
            //aqui se muestra el tiempo y distancia
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(route.startLocation, 16));
            ((TextView) findViewById(R.id.tvCronometro)).setText(route.duration.text);
            ((TextView) findViewById(R.id.tvDistancia)).setText(route.distance.text);

            PolylineOptions polylineOptions = new PolylineOptions().
                    geodesic(true).
                    color(Color.DKGRAY). //aqui color
                    width(10);

            for (int i = 0; i < route.points.size(); i++)
                polylineOptions.add(route.points.get(i));

            polylinePaths.add(mMap.addPolyline(polylineOptions));
        }
    }
}