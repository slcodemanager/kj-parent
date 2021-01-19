package com.kj.consume.controller.order;

import com.kj.common.result.R;
import com.kj.consume.service.OrderService;
import com.kj.consume.vo.BuyItParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author quan
 * @date 2021-01-18 17:23
 */

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("buyIt")
    public R buyIt(BuyItParams params){
        String orderId = orderService.buyIt(params);

    }
}
