package exportkit.xd;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity4 extends AppCompatActivity {
    Button location, location2;
    private TextView tv2, tv3, tv4, tv5, tv1;
    public static String V1;
    Button Send_location;
    StorageReference storageReference;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    String userId;



    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Send_location = findViewById(R.id.Send_location);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);

        mAuth = FirebaseAuth.getInstance();
        userId = mAuth.getCurrentUser().getUid();

        Send_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendlocation();
            }
        });

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(MainActivity4.this,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getLocation();
        } else {
            ActivityCompat.requestPermissions(MainActivity4.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }

    }

    private void sendlocation() {
        storageReference = FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference(userId);
        double numb1 = Double.parseDouble(tv1.getText().toString());
       double numb2 = Double.parseDouble(tv2.getText().toString());
        String numb3 = String.valueOf(tv3.getText());
        String numb4 = String.valueOf(tv4.getText());
        String numb5 = String.valueOf(tv5.getText());
        String upload = databaseReference.push().getKey();
        databaseReference.child("Locationfolder").child("Latitude").setValue(numb1);
       databaseReference.child("Locationfolder").child("Longitude").setValue(numb2);
        databaseReference.child("Locationfolder").child("Country name").setValue(numb3);
       databaseReference.child("Locationfolder").child("Locality").setValue(numb4);
        databaseReference.child("Locationfolder").child("Address line").setValue(numb5);
        Toast.makeText(MainActivity4.this, "Saved", Toast.LENGTH_LONG).show();
    }



    private void getLocation() {

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


        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location1 = task.getResult();
                if (location1 != null) {
                    Geocoder geocoder = new Geocoder(MainActivity4.this,
                            Locale.getDefault());
                    try {

                        List<Address> addresses = geocoder.getFromLocation(
                                location1.getLatitude(), location1.getLongitude(), 1
                        );


//                        tv1.setText(Html.fromHtml(
//                               "<font color = '#6200EE'><b>Latitude :<b><br></font>"
////
//                                     + addresses.get(0).getLatitude()));

                        //String V1 = String.valueOf(tv1);
                        tv1.setText(String.valueOf(addresses.get(0).getLatitude()));


                        tv2.setText(String.valueOf(addresses.get(0).getLongitude()));
                        tv3.setText(String.valueOf(addresses.get(0).getCountryName()));
                        tv4.setText(String.valueOf(addresses.get(0).getLocality()));
                        tv5.setText(String.valueOf(addresses.get(0).getAddressLine(0)));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }

            }
        });

//        location2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //  Log.d(String.valueOf(tv1), "tv1: " + tv1.getText().toString());
//                ParseObject location = new ParseObject("location");
//
//                double numb1 = Double.parseDouble(tv1.getText().toString());
//                double numb2 = Double.parseDouble(tv2.getText().toString());
//                String numb3 = String.valueOf(tv3.getText());
//                String numb4 = String.valueOf(tv4.getText());
//                String numb5 = String.valueOf(tv5.getText());
//
//
//            }
//        });

    }
}
