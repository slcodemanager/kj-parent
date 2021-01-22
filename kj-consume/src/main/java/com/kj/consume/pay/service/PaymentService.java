package com.kj.consume.pay.service;

import com.kj.consume.pay.WxPayRequestHandler;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * @author quan
 * @date 2021-01-20 15:31
 */

public interface PaymentService {
    void assignPayParams(HttpServletRequest request, WxPayRequestHandler requestHandler, String orderId, BigDecimal price, String body) throws Exception;
}
