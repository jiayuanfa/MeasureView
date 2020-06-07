package com.example.customviewdemo;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;

public class Util {
    public static void badgeView(Activity activity) {
        ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
        View badge = new View(activity);
        badge.setBackgroundColor(Color.BLUE);
        decorView.addView(badge, 200, 200);
    }
}
