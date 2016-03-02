package com.dkhs.customrowview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dkhs.customrowview.bean.GroupDescriptor;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/1.
 */
public class ContainerView extends LinearLayout {
    private Context context;
    private ArrayList<GroupDescriptor> list;
    private OnRowClickListener listener;

    public ContainerView(Context context) {
        super(context);
        initView(context);
    }

    public ContainerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ContainerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        setOrientation(VERTICAL);
    }

    public void initData(ArrayList<GroupDescriptor> list, OnRowClickListener listener) {
        this.list = list;
        this.listener = listener;

    }

    public void notifyDataChanged() {
        if (list != null || list.size() > 0) {
            GroupView groupView;
            float density = context.getResources().getDisplayMetrics().density;
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.topMargin = (int) (20 * density);
            for (GroupDescriptor descriptor : list) {
                groupView = new GroupView(context);
                groupView.initData(descriptor, listener);
                groupView.notifyDataChanged();
                addView(groupView,params);
            }
            setVisibility(View.VISIBLE);
        } else {
            setVisibility(View.GONE);
        }
    }
}
