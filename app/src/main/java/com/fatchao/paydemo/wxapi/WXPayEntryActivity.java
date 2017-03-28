package com.fatchao.paydemo.wxapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.fatchao.paydemo.Constant;
import com.fatchao.paydemo.pay.wechat.WeChatWay;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WeChatWay.getInstance(Constant.APP_ID).getApi().handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        WeChatWay.getInstance(Constant.APP_ID).getApi().handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    /**
     * 四、接收支付返回结果
     */
    @Override
    public void onResp(BaseResp resp) {
        WeChatWay.getInstance(Constant.APP_ID).onResponse(resp.errCode);
        finish();
    }
}