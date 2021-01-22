package com.kj.consume.controller.order;

import com.kj.common.result.R;
import com.kj.consume.entity.KUserAddress;
import com.kj.consume.service.OrderService;
import com.kj.consume.vo.BuyItParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author quan
 * @date 2021-01-18 17:23
 */

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("buyIt")
    public R buyIt(BuyItParams params) {
        return R.ok(orderService.buyIt(params));
    }

    @PostMapping("/address")
    public R userAddress(KUserAddress params) {
        orderService.addUserAddress(params);
        return R.ok();
    }

    @GetMapping("/address/{userId}")
    public R userAddress(@PathVariable("userId") Long userId) {
        return R.ok(orderService.getUserAddressListByUserId(userId));
    }
}
