package com.dkhs.customrowview.bean;

import com.dkhs.customrowview.RowActionEnum;

/**
 * Created by Administrator on 2016/3/1.
 */
public class RowProfileDescriptor extends BaseRowDescriptor {
    public int imgrResid;
    public String label;
    public String detailLabel;
    public RowActionEnum actionEnum;

    public RowProfileDescriptor(int imgrResid, String label, String detailLabel, RowActionEnum actionEnum) {
        this.imgrResid = imgrResid;
        this.label = label;
        this.detailLabel = detailLabel;
        this.actionEnum = actionEnum;
    }
}
