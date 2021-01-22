package com.kj.consume.controller.order;

import com.kj.common.asser.A;
import com.kj.common.exp.E;
import com.kj.common.result.R;
import com.kj.common.utils.WxUtil;
import com.kj.consume.entity.KOrder;
import com.kj.consume.pay.WxPayRequestHandler;
import com.kj.consume.pay.service.PaymentService;
import com.kj.consume.service.OrderService;
import com.kj.consume.vo.PayVo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.http.client.utils.URLEncodedUtils;
import org.bouncycastle.crypto.engines.AESLightEngine;
import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 支付接口
 *
 * @author quan
 * @date 2021-01-20 15:27
 */
@RestController
@RequestMapping("/pay")
public class PaymentController {
    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
    private static final String REDIRECT_URL = "https://nilaibanjia.cn";
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private OrderService orderService;


    @PostMapping("/wx")
    public R wxPay(HttpServletRequest request, HttpServletResponse response, PayVo params) {
        KOrder order = orderService.getOrderByOrderId(params.getOrderId());
        A.notNull(order, "订单信息为空");
        A.of(order.getStatus() == 0 && order.getPayMoney().compareTo(BigDecimal.ZERO) > 0 && order.getExpressStatus() == 0, "订单异常");
        BigDecimal payMoney = order.getPayMoney();
        String orderId = order.getOrderId();
        WxPayRequestHandler requestHandler = new WxPayRequestHandler();
        try {
            paymentService.assignPayParams(request, requestHandler, orderId, payMoney, "kj pay");
            Map<String, String> map = requestHandler.sendPrepay();
            if (map != null) {
                StringBuilder redirect = new StringBuilder(map.get("mweb_url"));
                redirect.append("&").append("redirect_url").append("=").append(URLEncoder.encode(REDIRECT_URL, "utf-8"));
                return R.ok(redirect.toString());
            } else {
                logger.error("获取预支付信息错误map==null " + " debug info==" + requestHandler.getDebugInfo());
                throw new E("获取预支付信息错误map==null" + " debug info==" + requestHandler.getDebugInfo());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return R.ok(e.getMessage());
        }
    }

    @RequestMapping(value = "/wxNotify",method = {RequestMethod.GET,RequestMethod.POST})
    public void wxNotify(HttpServletRequest request, HttpServletResponse response) {
        BufferedReader read = null;
        PrintWriter writer = null;
        String line;
        try {
            writer =response.getWriter();
            read = request.getReader();
            StringBuilder result = new StringBuilder();
            while ((line = read.readLine()) != null) {
                result.append(line);
            }
            logger.debug("wxNotify----接收到的报文---" + result.toString());
            Map<String, String> map = WxUtil.doXMLParse(result.toString());
            if (map != null && map.get("result_code").equalsIgnoreCase("SUCCESS")) {
                String orderId = map.get("out_trade_no");
                KOrder order = orderService.getOrderByOrderId(orderId);
                A.notNull(order, "订单信息错误");
                if (order.getStatus() == 1) {
                    logger.info("已经处理过的支付回调");
                } else {
                    String transactionId = map.get("transaction_id");
                    orderService.updOrderPayInfo(orderId, 1, transactionId);
                }
                writer.write(WxUtil.parseResultForWX(true));
                response.flushBuffer();
                logger.info("wxNotify----已经处理好回调----");
            }
        } catch (Exception e) {
            logger.error("wxNotify异常:{}", e.getMessage());
            try {
                writer.write(WxUtil.parseResultForWX(false));
                response.flushBuffer();
                logger.info("wxNotify----还没处理好回调----");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                writer.close();
            }

        }


    }
}
