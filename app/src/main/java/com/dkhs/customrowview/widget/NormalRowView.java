package com.dkhs.customrowview.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.dkhs.customrowview.bean.BaseRowDescriptor;
import com.dkhs.customrowview.R;
import com.dkhs.customrowview.RowActionEnum;
import com.dkhs.customrowview.bean.RowDescriptor;

/**
 * Created by Administrator on 2016/2/29.
 */
public class NormalRowView extends BaseRowView implements View.OnClickListener {
    private Context context;
    private ImageView mWidgetRowIcon;
    private TextView mWidgetRowlabel;
    private ImageButton mWidgetRowActionBar;
    private RowActionEnum actionEnum;
    private OnRowClickListener listener;
    private RowDescriptor descriptor;
    // End Of Content View Elements

    private void bindViews() {
        LayoutInflater.from(context).inflate(R.layout.widget_general_rowview, this);
        mWidgetRowIcon = (ImageView) findViewById(R.id.mWidgetRowIcon);
        mWidgetRowlabel = (TextView) findViewById(R.id.mWidgetRowlabel);
        mWidgetRowActionBar = (ImageButton) findViewById(R.id.mWidgetRowActionBar);
    }

    public NormalRowView(Context context) {
        super(context);
        this.context = context;
        bindViews();
    }

    public NormalRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        bindViews();
    }

    public NormalRowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        bindViews();
    }

    public void initData(int labelResid, String name, RowActionEnum actionEnum, OnRowClickListener listener) {
        this.actionEnum = actionEnum;
        this.listener = listener;
        mWidgetRowIcon.setBackgroundResource(labelResid);
        mWidgetRowlabel.setText(name);
        if (actionEnum != null) {
            setOnClickListener(this);
            setBackgroundResource(R.drawable.widget_rowview_general_select);
            mWidgetRowActionBar.setVisibility(VISIBLE);
        } else {
            setBackgroundColor(Color.WHITE);
            mWidgetRowActionBar.setVisibility(GONE);
        }

    }

    public void initData(int labelResid, String name) {
        mWidgetRowIcon.setBackgroundResource(labelResid);
        mWidgetRowlabel.setText(name);
        setBackgroundColor(Color.WHITE);
        mWidgetRowActionBar.setVisibility(GONE);

    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onRowClick(descriptor.actionEnum);
        }
    }

    public void initData(BaseRowDescriptor descriptor, OnRowClickListener listener) {
        this.descriptor = (RowDescriptor) descriptor;
        this.listener = listener;
    }

    public void notifyDataChanged() {
        if(descriptor!=null){
            mWidgetRowIcon.setBackgroundResource(descriptor.iconResid);
            mWidgetRowlabel.setText(descriptor.label);
            if (descriptor.actionEnum != null) {
                setOnClickListener(this);
                setBackgroundResource(R.drawable.widget_rowview_general_select);
                mWidgetRowActionBar.setVisibility(VISIBLE);
            } else {
                setBackgroundColor(Color.WHITE);
                mWidgetRowActionBar.setVisibility(GONE);
            }
        }else{
            setVisibility(GONE);
        }
    }
}
