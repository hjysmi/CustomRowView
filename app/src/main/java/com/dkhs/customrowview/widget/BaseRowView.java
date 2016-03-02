package com.dkhs.customrowview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.dkhs.customrowview.bean.BaseRowDescriptor;

/**
 * Created by Administrator on 2016/3/1.
 */
public abstract class BaseRowView extends LinearLayout {
    public BaseRowView(Context context) {
        super(context);
    }

    public BaseRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseRowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public abstract void initData(BaseRowDescriptor descriptor,OnRowClickListener listener);

    public abstract void notifyDataChanged();
}
