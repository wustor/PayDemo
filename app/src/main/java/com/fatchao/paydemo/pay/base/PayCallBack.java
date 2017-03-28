package com.fatchao.paydemo.pay.base;

/**
 * Created by fatchao
 * 日期  2017/3/21.
 * 邮箱  18521092686@163.com
 */

public interface PayCallBack {
    // code: 0为失败，-1为失败,-2为取消
    void onResponse(int code);
}
