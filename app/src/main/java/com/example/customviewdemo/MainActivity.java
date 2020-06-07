package com.example.customviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        long startTime = SystemClock.uptimeMillis();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Util.badgeView(this);
        long timePassed = SystemClock.uptimeMillis() - startTime;
        Log.d("方法执行时间：" , "onCreate:" + timePassed);
    }
}
