package com.dkhs.customrowview.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/3/1.
 */
public class GroupDescriptor {
    public String title;
    public ArrayList<BaseRowDescriptor> rowDescriptors;

    public GroupDescriptor(String title, ArrayList<BaseRowDescriptor> rowDescriptors) {
        this.title = title;
        this.rowDescriptors = rowDescriptors;
    }

    public GroupDescriptor(ArrayList<BaseRowDescriptor> rowDescriptors) {
        this.rowDescriptors = rowDescriptors;
    }
}
