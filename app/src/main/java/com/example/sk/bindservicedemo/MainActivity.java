package com.example.sk.bindservicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MyBindServiceDemo";
    private TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtData = (TextView) findViewById(R.id.txtData);
    }

    public void startBindService(View view) {
        Intent intent = new Intent(MainActivity.this, MyBindService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(TAG, "onServiceConnected: ");

            MyBindService.MyBinder myBinder = (MyBindService.MyBinder) iBinder;
            MyBindService myBindService = myBinder.getService();
            String data = myBindService.getData();
            txtData.setText(data);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
}

