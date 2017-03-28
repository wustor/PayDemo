package com.fatchao.paydemo.bean;


import com.fatchao.paydemo.pay.base.BasePayBean;

/**
 * Created by pinlu-001 on 16/9/26.
 */

public class AlipayBean extends BasePayBean {


    /**
     * code : payParamSuccess
     * data : {"app_id":"2017011505111268","biz_content":"{\"body\":\"商品详情\",\"out_trade_no\":\"58d766d2574d740489e21bab\",\"product_code\":\"QUICK_MSECURITY_PAY\",\"subject\":\"品路车品订单\",\"timeout_express\":\"90m\",\"total_amount\":\"0.10\"}","charset":"utf-8","method":"alipay.trade.app.pay","notify_url":"http://tajia.iisu.cn/server/pay/ali/app/notify.do","sign_type":"RSA2","timestamp":"2017-03-26 14:59:30","version":"1.0","sign_string":"app_id=2017011505111268&biz_content={\"body\":\"商品详情\",\"out_trade_no\":\"58d766d2574d740489e21bab\",\"product_code\":\"QUICK_MSECURITY_PAY\",\"subject\":\"品路车品订单\",\"timeout_express\":\"90m\",\"total_amount\":\"0.10\"}&charset=utf-8&method=alipay.trade.app.pay&notify_url=http://tajia.iisu.cn/server/pay/ali/app/notify.do&sign_type=RSA2&timestamp=2017-03-26 14:59:30&version=1.0","sign":"kEv+E/pLVn9617SGs0bn1tPPKWJPhzsn0CRH26mr0LqKmCnyty6T3kdgf6c+GoWFexEROtdykowkmnIT6TyFYyXds4AoKWmexyFBxXdehfB865JpKdyT1Y9EmNLFrAa7yJlBiZCB4f63k90RE9BlzXHw6lTeT1sZ09pUF6fnZQWLb6oYcJR9dUzTIgXl7l3j7NQRHvKPYMrZSyY3exZwWFZfD7E8aPtVwg58gnkSXQl1d4hglkR10bAiczqqufinlgJCogPjWcVDPDp4QKebMlaMU67+x+Nu7uMybalM8EiQz6WY01M1+C0B6tsSJYFgnR3pejMAfQGOQHNJTc1I0Q==","encoder":"app_id=2017011505111268&biz_content=%7B%22body%22%3A%22%E5%95%86%E5%93%81%E8%AF%A6%E6%83%85%22%2C%22out_trade_no%22%3A%2258d766d2574d740489e21bab%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E5%93%81%E8%B7%AF%E8%BD%A6%E5%93%81%E8%AE%A2%E5%8D%95%22%2C%22timeout_express%22%3A%2290m%22%2C%22total_amount%22%3A%220.10%22%7D&charset=utf-8&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Ftajia.iisu.cn%2Fserver%2Fpay%2Fali%2Fapp%2Fnotify.do&sign_type=RSA2&timestamp=2017-03-26+14%3A59%3A30&version=1.0&sign=kEv%2BE%2FpLVn9617SGs0bn1tPPKWJPhzsn0CRH26mr0LqKmCnyty6T3kdgf6c%2BGoWFexEROtdykowkmnIT6TyFYyXds4AoKWmexyFBxXdehfB865JpKdyT1Y9EmNLFrAa7yJlBiZCB4f63k90RE9BlzXHw6lTeT1sZ09pUF6fnZQWLb6oYcJR9dUzTIgXl7l3j7NQRHvKPYMrZSyY3exZwWFZfD7E8aPtVwg58gnkSXQl1d4hglkR10bAiczqqufinlgJCogPjWcVDPDp4QKebMlaMU67%2Bx%2BNu7uMybalM8EiQz6WY01M1%2BC0B6tsSJYFgnR3pejMAfQGOQHNJTc1I0Q%3D%3D"}
     */

    private String code;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * app_id : 2017011505111268
         * biz_content : {"body":"商品详情","out_trade_no":"58d766d2574d740489e21bab","product_code":"QUICK_MSECURITY_PAY","subject":"品路车品订单","timeout_express":"90m","total_amount":"0.10"}
         * charset : utf-8
         * method : alipay.trade.app.pay
         * notify_url : http://tajia.iisu.cn/server/pay/ali/app/notify.do
         * sign_type : RSA2
         * timestamp : 2017-03-26 14:59:30
         * version : 1.0
         * sign_string : app_id=2017011505111268&biz_content={"body":"商品详情","out_trade_no":"58d766d2574d740489e21bab","product_code":"QUICK_MSECURITY_PAY","subject":"品路车品订单","timeout_express":"90m","total_amount":"0.10"}&charset=utf-8&method=alipay.trade.app.pay&notify_url=http://tajia.iisu.cn/server/pay/ali/app/notify.do&sign_type=RSA2&timestamp=2017-03-26 14:59:30&version=1.0
         * sign : kEv+E/pLVn9617SGs0bn1tPPKWJPhzsn0CRH26mr0LqKmCnyty6T3kdgf6c+GoWFexEROtdykowkmnIT6TyFYyXds4AoKWmexyFBxXdehfB865JpKdyT1Y9EmNLFrAa7yJlBiZCB4f63k90RE9BlzXHw6lTeT1sZ09pUF6fnZQWLb6oYcJR9dUzTIgXl7l3j7NQRHvKPYMrZSyY3exZwWFZfD7E8aPtVwg58gnkSXQl1d4hglkR10bAiczqqufinlgJCogPjWcVDPDp4QKebMlaMU67+x+Nu7uMybalM8EiQz6WY01M1+C0B6tsSJYFgnR3pejMAfQGOQHNJTc1I0Q==
         * encoder : app_id=2017011505111268&biz_content=%7B%22body%22%3A%22%E5%95%86%E5%93%81%E8%AF%A6%E6%83%85%22%2C%22out_trade_no%22%3A%2258d766d2574d740489e21bab%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22subject%22%3A%22%E5%93%81%E8%B7%AF%E8%BD%A6%E5%93%81%E8%AE%A2%E5%8D%95%22%2C%22timeout_express%22%3A%2290m%22%2C%22total_amount%22%3A%220.10%22%7D&charset=utf-8&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Ftajia.iisu.cn%2Fserver%2Fpay%2Fali%2Fapp%2Fnotify.do&sign_type=RSA2&timestamp=2017-03-26+14%3A59%3A30&version=1.0&sign=kEv%2BE%2FpLVn9617SGs0bn1tPPKWJPhzsn0CRH26mr0LqKmCnyty6T3kdgf6c%2BGoWFexEROtdykowkmnIT6TyFYyXds4AoKWmexyFBxXdehfB865JpKdyT1Y9EmNLFrAa7yJlBiZCB4f63k90RE9BlzXHw6lTeT1sZ09pUF6fnZQWLb6oYcJR9dUzTIgXl7l3j7NQRHvKPYMrZSyY3exZwWFZfD7E8aPtVwg58gnkSXQl1d4hglkR10bAiczqqufinlgJCogPjWcVDPDp4QKebMlaMU67%2Bx%2BNu7uMybalM8EiQz6WY01M1%2BC0B6tsSJYFgnR3pejMAfQGOQHNJTc1I0Q%3D%3D
         */

        private String app_id;
        private String biz_content;
        private String charset;
        private String method;
        private String notify_url;
        private String sign_type;
        private String timestamp;
        private String version;
        private String sign_string;
        private String sign;
        private String encoder;

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public String getBiz_content() {
            return biz_content;
        }

        public void setBiz_content(String biz_content) {
            this.biz_content = biz_content;
        }

        public String getCharset() {
            return charset;
        }

        public void setCharset(String charset) {
            this.charset = charset;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getNotify_url() {
            return notify_url;
        }

        public void setNotify_url(String notify_url) {
            this.notify_url = notify_url;
        }

        public String getSign_type() {
            return sign_type;
        }

        public void setSign_type(String sign_type) {
            this.sign_type = sign_type;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getSign_string() {
            return sign_string;
        }

        public void setSign_string(String sign_string) {
            this.sign_string = sign_string;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getEncoder() {
            return encoder;
        }

        public void setEncoder(String encoder) {
            this.encoder = encoder;
        }
    }
}
