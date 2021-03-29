package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Fetty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetty);

        Intent intent = getIntent();
        String editTextMessage = intent.getStringExtra("Messsage");
        //Getting the reference of the TextView
        TextView textView = findViewById(R.id.tv2);
        textView.setText(editTextMessage);

    }
}
