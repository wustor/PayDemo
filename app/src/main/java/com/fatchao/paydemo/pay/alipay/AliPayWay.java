package com.fatchao.paydemo.pay.alipay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;

import com.alipay.sdk.app.AuthTask;
import com.alipay.sdk.app.PayTask;
import com.fatchao.paydemo.BaseApplication;
import com.fatchao.paydemo.bean.AlipayBean;
import com.fatchao.paydemo.pay.base.BasePayWay;
import com.fatchao.paydemo.pay.base.PayCallBack;

import java.util.Map;

/**
 * Created by fatchao
 * 日期  2017/3/21.
 * 邮箱  18521092686@163.com
 */

public class AliPayWay implements BasePayWay<AlipayBean> {
    //商户PID
    public static final String PARTNER = "";
    //商户收款账号
    //商户私钥，pkcs8格式
    public static String RSA_PRIVATE = "";
    public static final int SDK_PAY_FLAG = 1;
    public static final int SDK_CHECK_FLAG = 2;
    public PayCallBack mPayCallBack;
    private Activity mActivity;

    //--------支付宝支付回调-----
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case AliPayWay.SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    // 支付宝返回此次支付结果及加签，建议对支付宝签名信息拿签约时支付宝提供的公钥做验签
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        mPayCallBack.onResponse(0);
                    } else {
                        // 判断resultStatus 为非“9000”则代表可能支付失败
                        // “8000”代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            Toast.makeText(mActivity, "支付结果确认中", Toast.LENGTH_SHORT).show();
                        } else if (TextUtils.equals(resultStatus, "6001")) {
                            mPayCallBack.onResponse(-2);
                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            mPayCallBack.onResponse(-1);

                        }
                    }
                    break;
                }
                case AliPayWay.SDK_CHECK_FLAG: {
                    Toast.makeText(BaseApplication.getContext(), "检查结果为：" + msg.obj, Toast.LENGTH_SHORT).show();
                    break;
                }
                default:
                    break;
            }
        }
    };

    /**
     * sign the order info. 对订单信息进行签名
     *
     * @param content 待签名订单信息
     */
    public String sign(String content) {

        return SignUtils.sign(content, RSA_PRIVATE);
    }

    /**
     * get the sign type we use. 获取签名方式
     */
    public String getSignType() {
        return "sign_type=\"RSA2\"";
    }

    @Override
    public void startPay(Activity activity, AlipayBean alipayBean, PayCallBack payCallback) {
        this.mActivity = activity;
        this.mPayCallBack = payCallback;
//        String sign = OrderInfoUtil2_0.getSign(authInfoMap, privateKey, rsa2);
//        final String authInfo = info + "&" + sign;
//        String orderInfo = alipayBean.getData().getSign_string();
//        String sign = alipayBean.getData().getSign();
//        try {
//            // 仅需对sign 做URL编码
//            sign = URLEncoder.encode(sign, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        // 完整的符合支付宝参数规范的订单信息
//        final String payInfo = orderInfo + "&sign=\"" + sign + "\"&" + getSignType();
        final String authInfo = alipayBean.getData().getEncoder();
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                // 构造AuthTask 对象
                AuthTask authTask = new AuthTask(mActivity);
                // 调用授权接口，获取授权结果
                Map<String, String> result = authTask.authV2(authInfo, true);
                PayTask alipay = new PayTask(mActivity);
                // 调用支付接口，获取支付结果
//                String result = alipay.pay(payInfo, true);
                Message msg = new Message();
                msg.what = AliPayWay.SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }
}
