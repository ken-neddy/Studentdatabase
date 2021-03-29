package com.example.cookie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void eatCookie(View view){
        ImageView imageView =(ImageView)findViewById(R.id.cookie_image_view);
        imageView.setImageResource(R.drawable.after_cookie);

        TextView textView = (TextView)findViewById(R.id.eat_cookie_text);
        textView.setText("Am Cool");
    }
}