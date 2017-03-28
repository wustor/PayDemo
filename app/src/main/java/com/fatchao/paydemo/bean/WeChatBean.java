package com.fatchao.paydemo.bean;


import com.fatchao.paydemo.pay.base.BasePayBean;

/**
 * Created by chao on 2016/3/1.
 */
public class WeChatBean extends BasePayBean {

    private String code;
    private String message;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * appid : wx47c41d2672af6c45
         * partnerid : 1440127702
         * prepayid : wx2017032410262300e3a6ea7d0357214434
         * package_ : Sign=WXPay
         * noncestr : u7nkocaq3s8otcopngfwvf7kxee4qk9w
         * timestamp : 1490322383
         * sign : 8BF7262CB4A120D248EEE93C353563CC
         */

        private String appid;
        private String partnerid;
        private String prepayid;
        private String package_;
        private String noncestr;
        private String timestamp;
        private String sign;

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getPartnerid() {
            return partnerid;
        }

        public void setPartnerid(String partnerid) {
            this.partnerid = partnerid;
        }

        public String getPrepayid() {
            return prepayid;
        }

        public void setPrepayid(String prepayid) {
            this.prepayid = prepayid;
        }

        public String getPackage_() {
            return package_;
        }

        public void setPackage_(String package_) {
            this.package_ = package_;
        }

        public String getNoncestr() {
            return noncestr;
        }

        public void setNoncestr(String noncestr) {
            this.noncestr = noncestr;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }
    }
}
