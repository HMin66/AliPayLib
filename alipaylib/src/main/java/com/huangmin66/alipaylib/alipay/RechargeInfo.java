package com.huangmin66.alipaylib.alipay;

public class RechargeInfo {

    /**
     * re : 1
     * info : {"_input_charset":"utf-8","body":"贵诺APP余额充值","notify_url":"http://xiangniu.unohacha.com/Api/Api/Ucenter_rechargeSuccess","out_trade_no":"2017081218134422221","partner":"2088201398964998","payment_type":"1","seller_id":"2088201398964998","service":"mobile.securitypay.pay","subject":"贵诺APP余额充值","total_fee":"1.00","sign":"FSmpkSbXA70m3aFxpJSOSRlXag0vUBTYhzOhAwqPd3dp6og5RE8aui%2FV3cnxHwQ%2F2kXtX9%2BrSaFP8nfaoFk67sV3gBiPVgNiHHvo9vWWmc7BYpetPWJChTl1BdrlSeoyLEXHlcEvYF7VvzFUhiSw90cL5S1I67PxncMUaVlvRVk%3D","sign_type":"RSA2"}
     */

    private String re;
    private InfoBean info;

    public String getRe() {
        return re;
    }

    public void setRe(String re) {
        this.re = re;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean {
        /**
         * _input_charset : utf-8
         * body : 贵诺APP余额充值
         * notify_url : http://xiangniu.unohacha.com/Api/Api/Ucenter_rechargeSuccess
         * out_trade_no : 2017081218134422221
         * partner : 2088201398964998
         * payment_type : 1
         * seller_id : 2088201398964998
         * service : mobile.securitypay.pay
         * subject : 贵诺APP余额充值
         * total_fee : 1.00
         * sign : FSmpkSbXA70m3aFxpJSOSRlXag0vUBTYhzOhAwqPd3dp6og5RE8aui%2FV3cnxHwQ%2F2kXtX9%2BrSaFP8nfaoFk67sV3gBiPVgNiHHvo9vWWmc7BYpetPWJChTl1BdrlSeoyLEXHlcEvYF7VvzFUhiSw90cL5S1I67PxncMUaVlvRVk%3D
         * sign_type : RSA2
         */

        private String _input_charset;
        private String body;
        private String notify_url;
        private String out_trade_no;
        private String partner;
        private String payment_type;
        private String seller_id;
        private String service;
        private String subject;
        private String total_fee;
        private String sign;
        private String sign_type;

        public String get_input_charset() {
            return _input_charset;
        }

        public void set_input_charset(String _input_charset) {
            this._input_charset = _input_charset;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getNotify_url() {
            return notify_url;
        }

        public void setNotify_url(String notify_url) {
            this.notify_url = notify_url;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public String getPartner() {
            return partner;
        }

        public void setPartner(String partner) {
            this.partner = partner;
        }

        public String getPayment_type() {
            return payment_type;
        }

        public void setPayment_type(String payment_type) {
            this.payment_type = payment_type;
        }

        public String getSeller_id() {
            return seller_id;
        }

        public void setSeller_id(String seller_id) {
            this.seller_id = seller_id;
        }

        public String getService() {
            return service;
        }

        public void setService(String service) {
            this.service = service;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getTotal_fee() {
            return total_fee;
        }

        public void setTotal_fee(String total_fee) {
            this.total_fee = total_fee;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getSign_type() {
            return sign_type;
        }

        public void setSign_type(String sign_type) {
            this.sign_type = sign_type;
        }
    }
}
