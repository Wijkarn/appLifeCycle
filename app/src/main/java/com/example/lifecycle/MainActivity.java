package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView im = findViewById(R.id.imageView);
        im.setRotation(180f);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Wijk", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Wijk", "onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Wijk", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Wijk", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Wijk", "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Wijk", "onResume");
    }
}