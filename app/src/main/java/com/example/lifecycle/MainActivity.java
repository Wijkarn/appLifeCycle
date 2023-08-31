package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    SensorManager sm;
    SensorEventListener listener;
    Sensor light;
    float lightValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //spinner();
        orientation();

        light();


    }

    public void light() {

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        light = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        listener = new SensorEventListener(){

            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float newLightValue = sensorEvent.values[0];
                if (lightValue != newLightValue){
                    Log.d("Wijk", String.valueOf(newLightValue));
                    lightValue = newLightValue;
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        sm.registerListener(listener, light, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void orientation() {
        int orientation = getResources().getConfiguration().orientation;
        Spinner spinnerPort;
        ArrayAdapter<CharSequence> adapter;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // In landscape
            spinnerPort = findViewById(R.id.spinner_land);
            adapter = ArrayAdapter.createFromResource(this, R.array.dropdown_land, android.R.layout.simple_spinner_item);
        } else {
            // In portrait
            spinnerPort = findViewById(R.id.spinner_port);
            adapter = ArrayAdapter.createFromResource(this, R.array.dropdown_port, android.R.layout.simple_spinner_item);
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerPort.setAdapter(adapter);
    }

    public void spinner() {
        Spinner spinnerPort = findViewById(R.id.spinner_port);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dropdown_port, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerPort.setAdapter(adapter);
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
        sm.unregisterListener(listener, light);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Wijk", "onResume");
    }
}