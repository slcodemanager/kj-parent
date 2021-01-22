package com.kj.consume.pay.impl;

import com.alibaba.fastjson.JSONObject;
import com.kj.common.utils.WxUtil;
import com.kj.consume.pay.WxPayRequestHandler;
import com.kj.consume.pay.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * @author quan
 * @date 2021-01-20 15:31
 */

@Service
public class PaymentServiceImpl  implements PaymentService {
    @Value("${wx.appId}")
    private String appId;
    @Value("${wx.appSecret}")
    private String appSecret;
    @Value("${wx.mchId}")
    private String mchId;
    @Value("${wx.payUrl}")
    private String payUrl;
    @Value("${wx.apiKey}")
    private String apiKey;
    @Value("${wx.notify}")
    private String notify;
    /**
     * 注意：
     * APPID必须为最后拉起收银台的小程序APPID；
     * mch_id为和appid成对绑定的支付商户号，收款资金会进入该商户号；
     */
    @Override
    public void assignPayParams(HttpServletRequest request,WxPayRequestHandler requestHandler, String orderId, BigDecimal price, String body) throws  Exception {
        String nonce_str = WxUtil.getNonceStr();
        int total_fee = price.multiply(BigDecimal.valueOf(100)).intValue();
        String ip = getRealIp(request);
        Map<String,String>  info = new HashMap<>();
        info.put("订单号：",orderId);
        requestHandler.setParameter("appid", appId);
        requestHandler.setParameter("mch_id", mchId);
        requestHandler.setParameter("nonce_str", nonce_str);
        requestHandler.setParameter("body", new String(body.getBytes("ISO-8859-1"), "UTF-8"));
        requestHandler.setParameter("out_trade_no", orderId);
        requestHandler.setParameter("total_fee", String.valueOf(total_fee));
        requestHandler.setParameter("spbill_create_ip", ip);
        requestHandler.setParameter("notify_url", notify);
        requestHandler.setParameter("trade_type", "MWEB");
        requestHandler.setParameter("scene_info", JSONObject.toJSONString(info));
        requestHandler.createSign();
        requestHandler.setGateUrl(payUrl);
        requestHandler.setKey(apiKey);
    }

    private static String getRealIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
