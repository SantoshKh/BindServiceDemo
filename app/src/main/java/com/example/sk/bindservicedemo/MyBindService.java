package com.example.sk.bindservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by SK on 3/23/2018.
 */

public class MyBindService extends Service {
    IBinder iBinder = new MyBinder();
    public static final String TAG = "MyBindServiceDemo";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return iBinder;
    }

    class MyBinder extends Binder {
        MyBindService getService() {
            return MyBindService.this;
        }


    }

    public String getData() {
        return "Data from Bind Service";
    }

}
