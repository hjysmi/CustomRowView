package com.dkhs.customrowview.bean;

import com.dkhs.customrowview.RowActionEnum;

/**
 * Created by Administrator on 2016/3/1.
 */
public class RowDescriptor extends BaseRowDescriptor{
    public int iconResid;
    public String label;

    public RowDescriptor(int iconResid, String label, RowActionEnum actionEnum) {
        this.iconResid = iconResid;
        this.label = label;
        this.actionEnum = actionEnum;
    }
}
