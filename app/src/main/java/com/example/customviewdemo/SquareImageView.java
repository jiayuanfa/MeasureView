package com.example.customviewdemo;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class SquareImageView extends AppCompatImageView {
    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
//        super.layout(l, t, l + (int)Utils.dpToPx(200f), t + (int)Utils.dpToPx(200f));

        // 取长边做正方形
//        int width = r - l;
//        int height = b - t;
//        int size = Math.min(width, height);
//        super.layout(l, t, l + size, t + size);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        // 重设View尺寸
        int measureWidth = getMeasuredWidth();
        int measureHeight = getMeasuredHeight();
        int size = Math.min(measureWidth, measureHeight);
        setMeasuredDimension(size, size);
    }
}
