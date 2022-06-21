package exportkit.xd;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Video extends AppCompatActivity {

        private static final int PICK_VIDEO_REQUEST= 1;


    private Button upload_video;
    private Button choosevideo;
    private VideoView videoView;
    private Uri videoUri;
    FirebaseAuth mAuth;
    String userId;
    MediaController mediaController;
    private StorageReference storageReference;
    private DatabaseReference databaseReference;
    private ProgressBar videoprogressBar;
    private EditText videoname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        upload_video=findViewById(R.id.upload_video);
        choosevideo=findViewById(R.id.choosevideo);
        videoView=findViewById(R.id.videoView);
        mAuth = FirebaseAuth.getInstance();
        userId = mAuth.getCurrentUser().getUid();

        videoprogressBar=findViewById(R.id.videoprogressBar);
        videoname=findViewById(R.id.videoname);

        mediaController=new MediaController(this);

        storageReference = FirebaseStorage.getInstance().getReference("videos");
        databaseReference = FirebaseDatabase.getInstance().getReference("videos");
        databaseReference = FirebaseDatabase.getInstance().getReference(userId);

        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.start();

                choosevideo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ChooseVideoMethod();

                    }
                });
        upload_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UploadVideoMethod();
            }
        });
    }


    private void ChooseVideoMethod() {
        //Intent intent = new Intent();
     //   intent.setType("Video/*");
     //  intent.setAction(Intent.ACTION_GET_CONTENT);
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_VIDEO_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==PICK_VIDEO_REQUEST && resultCode==RESULT_OK
                && data!=null && data.getData()!=null);

        videoUri=data.getData();
        videoView.setVideoURI(videoUri);

    }

//    private String getfileExt(Uri videoUri){
//        ContentResolver contentResolver=getContentResolver();
//        MimeTypeMap mimeTypeMap=MimeTypeMap.getSingleton();
//        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(videoUri));
//    }

    private void UploadVideoMethod() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading to server");
        progressDialog.show();
        StorageReference video = storageReference.child("videos/" + videoname);
        video.putFile(videoUri).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                double progress = (100.0*snapshot.getBytesTransferred())/snapshot.getTotalByteCount();
                progressDialog.setMessage("File uploaded..." + (int)progress+"%");
            }
        })
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        video.getDownloadUrl()
                                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        databaseReference.child("videosfolder")
                                                .child("my videos")
                                                .setValue(String.valueOf(uri))

//                                        DatabaseReference videos = FirebaseDatabase.getInstance().getReference().child("videos");
//                                        HashMap<String, String> hashMap = new HashMap<>();
//                                        hashMap.put("videourl", String.valueOf(uri));
//                                        videos.setValue(hashMap)

                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                progressDialog.dismiss();
                                                Toast.makeText(Video.this, "success", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                });
                    }
                });
    }
//    {
//        videoprogressBar.setVisibility(View.VISIBLE);
//        if (videoUri!=null){
//            StorageReference reference = storageReference.child(System.currentTimeMillis()+"."+getfileExt(videoUri));
//            reference.putFile(videoUri)
//                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            videoprogressBar.setVisibility(View.INVISIBLE);
//                            Toast.makeText(getApplicationContext(), "upload successful", Toast.LENGTH_SHORT).show();
//                            VideoUpload videoUpload = new VideoUpload(videoname.getText().toString(),
//                            taskSnapshot.getUploadSessionUri().toString());
//                            String upload = databaseReference.push().getKey();
//                            reference.getDownloadUrl().toString();
//                            databaseReference.child(upload).setValue(videoUpload);
//
//                        }
//
//
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
////                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
//        }else {
//            Toast.makeText(getApplicationContext(), "No file selected", Toast.LENGTH_SHORT).show();
//        }
//    }

}