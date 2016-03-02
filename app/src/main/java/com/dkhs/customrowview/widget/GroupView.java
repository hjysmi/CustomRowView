package com.dkhs.customrowview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.dkhs.customrowview.bean.BaseRowDescriptor;
import com.dkhs.customrowview.bean.GroupDescriptor;
import com.dkhs.customrowview.R;
import com.dkhs.customrowview.bean.RowDescriptor;
import com.dkhs.customrowview.bean.RowProfileDescriptor;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/1.
 */
public class GroupView extends LinearLayout {
    private ArrayList<BaseRowDescriptor> list;
    private Context context;
    private OnRowClickListener listener;
    private String title;

    public GroupView(Context context) {
        super(context);
        initView(context);
    }

    public GroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public GroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        setBackgroundResource(R.color.white);
        setOrientation(VERTICAL);
    }
    // rowView.initData(R.drawable.ic_info_draft, "草稿",RowActionEnum.MY_POSTS,this);

    /* public void initData(ArrayList<RowDescriptor> list,OnRowClickListener listener) {
         this.listener = listener;
         this.list = list;
     }*/
    public void initData(GroupDescriptor groupDescriptor, OnRowClickListener listener) {
        this.listener = listener;
        this.title = groupDescriptor.title;
        this.list = groupDescriptor.rowDescriptors;
        // this.list = list;
    }

    public void notifyDataChanged() {
        if (list != null && list.size() > 0) {
            BaseRowView rowView = null;
            View line = null;
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 2);
            params.leftMargin = 30;
            BaseRowDescriptor baseRowDescriptor;
            for (int i = 0; i < list.size(); i++) {
                baseRowDescriptor = list.get(i);
                if (baseRowDescriptor instanceof RowDescriptor) {
                    rowView = new NormalRowView(context);
                } else if (baseRowDescriptor instanceof RowProfileDescriptor) {
                    rowView = new ProfileRowView(context);
                }
                rowView.initData(list.get(i), listener);
                rowView.notifyDataChanged();
                addView(rowView);
                if (i != list.size() - 1) {
                    line = new View(context);
                    line.setBackgroundResource(R.color.widget_rowview_general_line);
                    addView(line, params);
                }
            }
        } else {
            setVisibility(View.GONE);
        }
    }
}
