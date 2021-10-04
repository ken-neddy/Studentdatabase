package com.neddycode.recyclerviewproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private ImageView loginAvatar;
    private EditText editTextTextEmailAddress;
    private EditText editTextTextPassword2;
    private Button button;
    private Button noAccount;
    private TextView forgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginAvatar = findViewById(R.id.loginavatar);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);
        button = findViewById(R.id.button);
        noAccount = findViewById(R.id.noAccount);
        forgotPassword = findViewById(R.id.forgotPassword);


        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }

    private void openActivity() {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }


}
