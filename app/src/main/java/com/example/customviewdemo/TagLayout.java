package com.example.customviewdemo;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义View的布局控制
 */
public class TagLayout extends ViewGroup {

    List<Rect> childrenBounds = new ArrayList<>();

    public TagLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 最长单行的宽度用来确定最终的TagLayout的宽度
        int widthUsed = 0;
        // 已经用掉的高度
        int heightUsed = 0;
        // 单行已经用掉的宽度，用来判断是否折行
        int lineWidthUsed = 0;
        // 单行最高行高，用来折行的时候进行叠加使用
        int lineHeight = 0;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);

            // 遍历计算每一个子View的位置，传入参数
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed);

            // 判断模式，进行折行的代码
            if (widthMode != MeasureSpec.UNSPECIFIED &&
                    lineWidthUsed + child.getMeasuredWidth() > widthSize) {
                lineWidthUsed = 0;
                heightUsed += lineHeight;
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed);
            }

            // 计算完毕，存入数组
            Rect childBounds;
            if (childrenBounds.size() <= i) {
                childBounds = new Rect();
                childrenBounds.add(childBounds);
            } else {
                childBounds = childrenBounds.get(i);
            }
            childBounds.set(lineWidthUsed, heightUsed, lineWidthUsed + child.getMeasuredWidth(),
                    heightUsed + child.getMeasuredHeight());

            // 更新单行使用掉的宽度
            lineWidthUsed += child.getMeasuredWidth();

            // 更新最长单行的宽度用来确定最终的TagLayout的宽度
            widthUsed = Math.max(lineWidthUsed, widthUsed);

            // 单行行高
            lineHeight = Math.max(lineHeight, child.getMeasuredHeight());
        }

        // 更新总的布局的行高
        int measuredWidth = widthUsed;
        heightUsed += lineHeight;
        int measuredHeight = heightUsed;

        // 保存总的宽高
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    /**
     * 因为上面onMeasure中使用到了measureChildWithMargins方法来计算child的布局
     * 所有这里要重写
     * @param attrs
     * @return
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    /**
     * 本质是通过子View的起点以及右下控制
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            Rect rect = childrenBounds.get(i);
            child.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }
}
