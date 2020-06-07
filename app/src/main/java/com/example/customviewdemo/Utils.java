package com.example.customviewdemo;

import android.content.res.Resources;
import android.util.TypedValue;

public class Utils {
    public static float dpToPx(float value) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, Resources.getSystem().getDisplayMetrics());
    }
}
