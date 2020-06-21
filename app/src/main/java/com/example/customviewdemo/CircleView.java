package com.example.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * 通过onMeasure来计算自定义View的宽高
 */
public class CircleView extends View {

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public static final float RADIUS = Utils.dpToPx(80f);
    public static final float PADDING = Utils.dpToPx(30f);

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 算出自定义View宽高 重设
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = (int) ((PADDING + RADIUS) * 2);
        int width = resolveSize(size, widthMeasureSpec);
        int height = resolveSize(size, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.RED);
        canvas.drawCircle(PADDING + RADIUS, PADDING +RADIUS, RADIUS, mPaint);
    }
}
