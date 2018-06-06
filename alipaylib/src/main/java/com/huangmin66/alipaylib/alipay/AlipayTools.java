package com.huangmin66.alipaylib.alipay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;

import java.util.Map;

public class AlipayTools {

    /**
     * 支付宝支付业务：入参app_id
     */
    public static final String APPID = "";

    /**
     * 支付宝账户登录授权业务：入参pid值
     */
    public static final String PID = "";


    //自定义支付状态
    public static final int PAY_SUCCESS = 1;
    public static final int PAY_COMFIRMING = 2;
    public static final int PAY_FAIL = 3;
    public static final int PAY_UNKNOW = 4;

    /**
     * 商户私钥，pkcs8格式
     */
    public static final String RSA2_PRIVATE = "";
    private static final int SDK_PAY_FLAG = 1;

    Activity activity;
    PayResultListner payResultListner;

    public interface PayResultListner {
        void onAlipayResult(int result, String msg);
    }

    public AlipayTools(Activity activity, PayResultListner payResultListner) {
        this.activity = activity;
        this.payResultListner = payResultListner;
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        payResultListner.onAlipayResult(PAY_SUCCESS, "支付成功");
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        payResultListner.onAlipayResult(PAY_FAIL, "支付失败");
                    }
                    break;
                }
                default:
                    break;
            }
        }

        ;
    };

    public void payV2(final String orderinfo) {
        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                //沙箱测试操作
//                EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);

                PayTask alipay = new PayTask(activity);
                Map<String, String> result = alipay.payV2(orderinfo, true);
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }


    /**
     * 支付宝支付业务
     *
     * @param infoBean
     */
    public void payV2(RechargeInfo.InfoBean infoBean) {
        /**
         * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
         * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
         * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
         *
         * orderInfo的获取必须来自服务端；
         */
//        Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID, info);
//        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);
//        String sign = OrderInfoUtil2_0.getSign(params, RSA2_PRIVATE);
//        final String orderInfo = orderParam + "&" + sign;

        final String orderinfo = "_input_charset=\"" + infoBean.get_input_charset() + "\"&body=\"" + infoBean.getBody() + "\"&notify_url=\"" + infoBean.getNotify_url() + "\"&out_trade_no=\"" + infoBean.getOut_trade_no() + "\"&partner=\"" + infoBean.getPartner() + "\"&payment_type=\"" + infoBean.getPayment_type() + "\"&seller_id=\"" + infoBean.getSeller_id() + "\"&service=\"" + infoBean.getService() + "\"&subject=\"" + infoBean.getSubject() + "\"&total_fee=\"" + infoBean.getTotal_fee() + "\"&sign=\"" + infoBean.getSign() + "\"&sign_type=\"" + infoBean.getSign_type() + "\"";

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                //沙箱测试操作
//                EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);

                PayTask alipay = new PayTask(activity);
                Map<String, String> result = alipay.payV2(orderinfo, true);
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    /**
     * get the sdk version. 获取SDK版本号
     */
    public void getSDKVersion() {
        PayTask payTask = new PayTask(activity);
        String version = payTask.getVersion();
        Toast.makeText(activity, version, Toast.LENGTH_SHORT).show();
    }

    /**
     * 原生的H5（手机网页版支付切natvie支付） 【对应页面网页支付按钮】
     *
     * @param v
     */
    public void h5Pay(View v) {
        Intent intent = new Intent(activity, H5PayDemoActivity.class);
        Bundle extras = new Bundle();
        /**
         * url是测试的网站，在app内部打开页面是基于webview打开的，demo中的webview是H5PayDemoActivity，
         * demo中拦截url进行支付的逻辑是在H5PayDemoActivity中shouldOverrideUrlLoading方法实现，
         * 商户可以根据自己的需求来实现
         */
        String url = "http://m.taobao.com";
        // url可以是一号店或者淘宝等第三方的购物wap站点，在该网站的支付过程中，支付宝sdk完成拦截支付
        extras.putString("url", url);
        intent.putExtras(extras);
        activity.startActivity(intent);
    }

}
