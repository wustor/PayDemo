package com.fatchao.paydemo.pay.base;

import android.app.Activity;

/**
 * Created by fatchao
 * 日期  2017/3/21.
 * 邮箱  18521092686@163.com
 */

public interface BasePayWay<T extends BasePayBean> {
    void startPay(Activity activity, T t, PayCallBack payCallback);
}
