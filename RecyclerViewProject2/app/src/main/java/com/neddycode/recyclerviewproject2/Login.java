package com.neddycode.recyclerviewproject2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    //declaring variables
    private ImageView loginAvatar;
    private EditText editTextTextEmailAddress;
    private EditText editTextTextPassword2;
    private Button button;
    private Button noAccount;
    private TextView forgotPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initializing views
        setContentView(R.layout.activity_login);
        loginAvatar = findViewById(R.id.loginavatar);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2);
        button = findViewById(R.id.button);
        noAccount = findViewById(R.id.noAccount);
        forgotPassword = findViewById(R.id.forgotPassword);



        //Implementation of Sign up button to open sign up activity
        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpActivity();
            }
        });


        //implementation of log in functionality
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailValue = editTextTextEmailAddress.getText().toString();
                String passwordValue = editTextTextPassword2.getText().toString();

                //Asking the server to allow log in for a registered account.
                ParseUser.logInInBackground(emailValue, passwordValue, new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {
                            //The user logged in
                            openActivity();
                            //Incase of an error
                        } else {
                            Toast.makeText(getApplicationContext(), "Sign in error", Toast.LENGTH_LONG)
                                    .show();
                        }
                    }
                });
            }
        });
    }

    private void openActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void openSignUpActivity() {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}
