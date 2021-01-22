package com.kj.consume.service;

import com.kj.consume.entity.KOrder;
import com.kj.consume.entity.KUserAddress;
import com.kj.consume.vo.BuyItParams;

import java.util.List;

/**
 * @author quan
 * @date 2021-01-18 17:24
 */

public interface OrderService {
    String buyIt(BuyItParams params);

    void addUserAddress(KUserAddress params);

    List<KUserAddress> getUserAddressListByUserId(Long userId);

    KOrder getOrderByOrderId(String orderId);

    void updOrderPayInfo(String orderId, Integer status, String transactionId) throws Exception;


}
