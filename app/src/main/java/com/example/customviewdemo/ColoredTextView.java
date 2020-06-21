package com.example.customviewdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * 随机颜色、随机大小的ColorTextView
 */
public class ColoredTextView extends AppCompatTextView {

    /**
     * 初始化一些随机颜色
     */
    private static final int[] COLORS = {
            Color.parseColor("#E91E63"),
            Color.parseColor("#673AB7"),
            Color.parseColor("#3F51B5"),
            Color.parseColor("#2196F3"),
            Color.parseColor("#009688"),
            Color.parseColor("#FF9800"),
            Color.parseColor("#FF5722"),
            Color.parseColor("#795548")
    };

    /**
     * 字体大小
     */
    private static final int[] TEXT_SIZES = {
        16,
        22,
        28
    };

    /**
     * 随机数控制
     */
    private static final Random random = new Random();

    /**
     * 圆角大小
     * X Y 内边距
     */
    private static final int CORNER_RADIUS = (int) Utils.dpToPx(10);
    private static final int X_PADDING = (int) Utils.dpToPx(16);
    private static final int Y_PADDING = (int) Utils.dpToPx(8);

    /**
     * 画笔
     */
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public ColoredTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    {
        setTextColor(Color.WHITE);
        setTextSize(TEXT_SIZES[random.nextInt(3)]);
        paint.setColor(COLORS[random.nextInt(COLORS.length)]);
        setPadding(X_PADDING, Y_PADDING, X_PADDING, Y_PADDING);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRoundRect(0, 0, getWidth(), getHeight(), CORNER_RADIUS, CORNER_RADIUS, paint);
        /**
         * 之所以写在绘制背景的前面，是为了不遮挡文字绘制
         */
        super.onDraw(canvas);
    }
}
