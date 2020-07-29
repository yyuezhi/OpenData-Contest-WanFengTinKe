package com.example.application.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class MyGridViewView extends GridView {
    public boolean isOnMeasure = false;

    public MyGridViewView(Context context) {
        super(context);
    }

    public MyGridViewView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyGridViewView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        isOnMeasure = true;
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        isOnMeasure = false;
        super.onLayout(changed, l, t, r, b);
    }
}
