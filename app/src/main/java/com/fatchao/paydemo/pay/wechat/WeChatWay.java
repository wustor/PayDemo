package com.fatchao.paydemo.pay.wechat;

import android.app.Activity;
import android.util.Log;

import com.pettimes.tajia.base.BaseApplication;
import com.pettimes.tajia.bean.WeChatBean;
import com.pettimes.tajia.pay.base.BasePayWay;
import com.pettimes.tajia.pay.base.PayCallBack;
import com.pettimes.tajia.utils.CommonUtils;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

/**
 * Created by fatchao
 * 日期  2017/3/21.
 * 邮箱  18521092686@163.com
 */

public class WeChatWay implements BasePayWay<WeChatBean> {
    private static WeChatWay mWeChatPay;
    private IWXAPI api;
    private PayCallBack mPayCallBack;
    private static final int TIMELINE_SUPPORTED_VERSION = 0x21020001;

    private WeChatWay(String wxAppId) {
        api = WXAPIFactory.createWXAPI(BaseApplication.getContext(), null);
        boolean b = api.registerApp(wxAppId);
        Log.d("result---->", String.valueOf(b));
    }

    public static WeChatWay getInstance(String wxAppId) {
        if (mWeChatPay == null) {
            synchronized (WeChatWay.class) {
                if (mWeChatPay == null) {
                    mWeChatPay = new WeChatWay(wxAppId);
                }
            }
        }
        return mWeChatPay;
    }

    public IWXAPI getApi() {
        return api;
    }

    private boolean checkWeChatPay() {
        int wxSdkVersion = api.getWXAppSupportAPI();
        boolean isWeChatAble = true;
        if (!api.isWXAppInstalled()) {
            CommonUtils.showToast(BaseApplication.getContext(), "使用微信支付必须先安装微信客户端");
            isWeChatAble = false;
        } else if (wxSdkVersion < TIMELINE_SUPPORTED_VERSION) {
            CommonUtils.showToast(BaseApplication.getContext(), "微信支付支持的最低版本高于当前安装版本，请先升级微信客户端");
            isWeChatAble = false;
        }
        return isWeChatAble;
    }

    @Override
    public void startPay(Activity activity, WeChatBean weChatBean, PayCallBack payCallback) {
        this.mPayCallBack = payCallback;
        if (checkWeChatPay()) {
            PayReq req = new PayReq();
            req.appId = weChatBean.getData().getAppid();
            req.partnerId = weChatBean.getData().getPartnerid();
            req.prepayId = weChatBean.getData().getPrepayid();
            req.packageValue = weChatBean.getData().getPackage_();
            req.nonceStr = weChatBean.getData().getNoncestr();
            req.timeStamp = weChatBean.getData().getTimestamp();
            req.sign = weChatBean.getData().getSign();
            api.sendReq(req);
        } else {
            mPayCallBack.onResponse(-1);
        }
    }

    public void onResponse(int code) {
        Log.d("code---->", String.valueOf(code));
        mPayCallBack.onResponse(code);
    }
}
