package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Getting a reference to the button
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });

    }

    private void openSecondActivity() {
        //Get the reference of the edit text
        EditText editText = findViewById(R.id.edit);
        //Get the data from the EditText
        String message = editText.getText().toString();
        Intent intent = new Intent(MainActivity.this, Fetty.class);
        intent.putExtra("Messsage", message);
        startActivity(intent);
    }
}
