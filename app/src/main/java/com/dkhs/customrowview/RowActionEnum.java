package com.dkhs.customrowview;

/**
 * Created by Administrator on 2016/2/29.
 */
public enum RowActionEnum {
    PHOTOS("相册"),
    COLLECTION("收藏"),
    WALLET("钱包"),
    COUPON("优惠券"),
    EMOTION("表情"),
    SETTING("设置"),
    WEIXIN("微信号");
    String type;

    RowActionEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
