package com.dkhs.customrowview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.dkhs.customrowview.bean.BaseRowDescriptor;
import com.dkhs.customrowview.bean.GroupDescriptor;
import com.dkhs.customrowview.bean.RowDescriptor;
import com.dkhs.customrowview.bean.RowProfileDescriptor;
import com.dkhs.customrowview.widget.ContainerView;
import com.dkhs.customrowview.widget.OnRowClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnRowClickListener {
    // Content View Elements
    private ContainerView containerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        containerView = (ContainerView) findViewById(R.id.mWidgetContainerView);
        ArrayList<GroupDescriptor> groupDescriptors = new ArrayList<>();
        ArrayList<BaseRowDescriptor> list3 = new ArrayList<>();
        list3.add(new RowProfileDescriptor(R.drawable.ic_info_flowpack, "远去的马蹄", "微信号:hjysmi", RowActionEnum.WEIXIN));
        GroupDescriptor groupDescriptor3 = new GroupDescriptor(list3);
        groupDescriptors.add(groupDescriptor3);

        ArrayList<BaseRowDescriptor> list1 = new ArrayList<>();
        list1.add(new RowDescriptor(R.drawable.ic_info_combina, RowActionEnum.PHOTOS.getType(), RowActionEnum.PHOTOS));
        list1.add(new RowDescriptor(R.drawable.ic_info_draft, RowActionEnum.COLLECTION.getType(), RowActionEnum.COLLECTION));
        list1.add(new RowDescriptor(R.drawable.ic_info_xuanshang, RowActionEnum.WALLET.getType(), RowActionEnum.WALLET));
        list1.add(new RowDescriptor(R.drawable.ic_info_xuanshang, RowActionEnum.COUPON.getType(), RowActionEnum.COUPON));
        GroupDescriptor groupDescriptor1 = new GroupDescriptor(list1);
        groupDescriptors.add(groupDescriptor1);

        ArrayList<BaseRowDescriptor> list2 = new ArrayList<>();
        list2.add(new RowDescriptor(R.drawable.ic_info_combina, RowActionEnum.EMOTION.getType(), RowActionEnum.EMOTION));
        GroupDescriptor groupDescriptor2 = new GroupDescriptor(list2);
        groupDescriptors.add(groupDescriptor2);

        ArrayList<BaseRowDescriptor> list4 = new ArrayList<>();
        list4.add(new RowDescriptor(R.drawable.ic_info_combina, RowActionEnum.SETTING.getType(), RowActionEnum.SETTING));
        GroupDescriptor groupDescriptor4 = new GroupDescriptor(list4);
        groupDescriptors.add(groupDescriptor4);

        containerView.initData(groupDescriptors, this);
        containerView.notifyDataChanged();


    }

    @Override
    public void onRowClick(RowActionEnum actionEnum) {

       /* switch (actionEnum) {
            case COMBINA:

                break;

        }*/
        Toast.makeText(MainActivity.this,  actionEnum.getType(), Toast.LENGTH_SHORT).show();
       /* int i = actionEnum.compareTo(RowActionEnum.COMBINA);
        Log.e("xue", "i= " + i);*/

    }
}
