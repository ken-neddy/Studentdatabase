
	 
	/*
     *	This content is generated from the API File Info.
     *	(Alt+Shift+Ctrl+I).
     *
     *	@desc
     *	@file 		suluhu
     *	@date 		1635510692890
     *	@title 		Page 1
     *	@author
     *	@keywords
     *	@generator 	Export Kit v1.3.figma
     *
     */


    package exportkit.xd;

    import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
    import android.text.TextUtils;
    import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
    import com.google.firebase.auth.FirebaseAuth;
    import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

    public class Reportpageaccount extends Activity {


        private View _bg__reportpage_ek2;
        private ImageView vector_ek34;
        private ImageView vector_ek35;
        private ImageView vector_ek36;
        private TextView _10_50_ek4;
        private TextView welcome__ek3;
        private View ellipse_1_ek4;
        private View ellipse_2_ek4;
        private View emergency_ek2;
        private View rectangle_2_ek2;
        private View rectangle_3_ek2;
        private Button take_a_pic;
        private TextView add_media_evidence;
        private View rectangle_1_ek4;
        private TextView send;
        private TextView briefly_explain_the_emergency;
        public String name;
        public String url;
        private Button add_doc;
        private Button add_vid;
        private Button save_location;
        StorageReference storageReference;
        DatabaseReference databaseReference;
        FusedLocationProviderClient fusedLocationProviderClient;
        FirebaseAuth mAuth;
        String userId;




        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_reportpageaccount);
            save_location = findViewById(R.id.save_location);
            take_a_pic = (Button) findViewById(R.id.take_a_pic);
            add_doc = (Button) findViewById(R.id.add_doc);
            add_vid=findViewById(R.id.add_vid);
            storageReference = FirebaseStorage.getInstance().getReference();
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
            mAuth = FirebaseAuth.getInstance();
            userId = mAuth.getCurrentUser().getUid();

            add_doc.setVisibility(View.INVISIBLE);


            add_doc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    add_doc();
                }
            });



            //Take a pic button to open camera activity
            take_a_pic.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    openCameraActivity();

                }
            });



            add_vid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openVideo();
                }
            });

            save_location.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openmaps();
                }
            });

        }




        //open add doc activity
        private void add_doc() {
            Intent intent = new Intent(this, adddoc.class);
            startActivity(intent);

        }



        // take a pic button intent
        private void openCameraActivity() {
            Intent intent = new Intent(this, Camera.class);
            startActivity(intent);
        }

        private void openmaps() {
            Intent intent = new Intent(this, MainActivity4.class);
            startActivity(intent);
        }

        private void openVideo() {
            Intent intent = new Intent(this, Video.class);
            startActivity(intent);
        }



        public void savedescriptionmethod(View view) {
            EditText editText = findViewById(R.id.Explain_emergency);
            String Explain_emergency = editText.getText().toString().trim();
            if (TextUtils.isEmpty(Explain_emergency)) {
                editText.setError("please fill");
                editText.requestFocus();
            } else{
         //   storageReference = FirebaseStorage.getInstance().getReference();
            databaseReference = FirebaseDatabase.getInstance().getReference(userId);
            String upload = databaseReference.push().getKey();
            databaseReference.child("Descriptionsfolder").child("mydescriptions").setValue(Explain_emergency);
            Toast.makeText(Reportpageaccount.this, "Saved", Toast.LENGTH_LONG).show();
        }
        }
    }


	
	