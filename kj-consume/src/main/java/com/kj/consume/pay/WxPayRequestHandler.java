package com.kj.consume.pay;

import com.kj.common.utils.HttpClient;
import com.kj.common.utils.WxUtil;
import org.apache.commons.lang3.StringUtils;
import org.jdom.JDOMException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WxPayRequestHandler extends RequestHandler {

    public WxPayRequestHandler() {
        super();
    }

    @Override
    public void createSign() {
        super.createSign();
    }

    // 提交预支付
    public Map<String, String> sendPrepay() throws JDOMException, IOException {
        Map<String, String> result = new HashMap<String, String>();
        String prepayid = "";
        StringBuilder sb = new StringBuilder("<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><xml>");
        sb.append(WxUtil.mapToXML(super.getAllParameters()));
        sb.append("</xml>");
        String params = sb.toString();
        params = new String(params.getBytes(), "ISO-8859-1");
        String requestUrl = super.getGateUrl();
        this.setDebugInfo(this.getDebugInfo() + "\r\n" + "requestUrl:" + requestUrl);
        HttpClient httpClient = new HttpClient();
        httpClient.setReqContent(requestUrl);
        String resContent = "";
        this.setDebugInfo(this.getDebugInfo() + "\r\n" + "post data:" + params);
        if (httpClient.callHttpPost(requestUrl, params)) {
            resContent = httpClient.getResContent();
            this.setDebugInfo(resContent);
            Map<String, String> map = WxUtil.doXMLParse(resContent);
            if (map != null && StringUtils.isNotEmpty(map.get("return_code")) && map.get("return_code").equals("SUCCESS")
                    && StringUtils.isNotEmpty(map.get("result_code")) && map.get("result_code").equals("SUCCESS")) {
                return map;
            }

        }
        return null;
    }
}
