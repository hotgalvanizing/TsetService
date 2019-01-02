package com.mx.tsetservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();

    Button startButton;
    Button stopButton;

    Button bindButton;
    Button unbindButton;
    Button getServiceStatus;

    MyService.MyBinder binder;

    Button intentServiceButton;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (MyService.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

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
        getServiceStatus = findViewById(R.id.status_btn);
        intentServiceButton = findViewById(R.id.start_intent_btn);

        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        bindButton.setOnClickListener(this);
        unbindButton.setOnClickListener(this);
        getServiceStatus.setOnClickListener(this);
        intentServiceButton.setOnClickListener(this);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        Log.d(TAG, "onPointerCaptureChanged: " + hasCapture);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, MyService.class);
        Intent intent1 = new Intent(this, MyIntentService.class);

        if (v == startButton) {
            startService(intent);
        }

        if (v == stopButton) {
            stopService(intent);
        }

        if (v == bindButton) {
            bindService(intent, conn, BIND_AUTO_CREATE);
        }

        if (v == unbindButton) {
            unbindService(conn);
        }

        if (v == getServiceStatus) {
            Toast.makeText(this, binder.getCount() + "", Toast.LENGTH_SHORT).show();
        }

        if (v == intentServiceButton){
            startService(intent1);
        }
    }
}
