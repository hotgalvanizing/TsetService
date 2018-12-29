package com.mx.tsetservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();

    Button startButton;
    Button stopButton;

    Button bindButton;
    Button unbindButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        startButton = findViewById(R.id.start_btn);
        stopButton = findViewById(R.id.stop_btn);
        bindButton = findViewById(R.id.bind_btn);
        unbindButton = findViewById(R.id.unbind_btn);

        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        bindButton.setOnClickListener(this);
        unbindButton.setOnClickListener(this);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        Log.d(TAG, "onPointerCaptureChanged: " + hasCapture);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, MyService.class);

        if (v == startButton) {
            startService(intent);
        }

        if (v == stopButton) {
            stopService(intent);
        }

        if (v == bindButton){

        }

        if (v == unbindButton){

        }
    }
}
