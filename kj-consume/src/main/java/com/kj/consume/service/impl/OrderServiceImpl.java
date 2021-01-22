package com.kj.consume.service.impl;

import com.kj.common.asser.A;
import com.kj.common.exp.E;
import com.kj.consume.base.BaseService;
import com.kj.consume.component.SnowFlakeComponent;
import com.kj.consume.entity.*;
import com.kj.consume.mapper.*;
import com.kj.consume.service.OrderService;
import com.kj.consume.service.ProductService;
import com.kj.consume.vo.BuyItParams;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author quan
 * @date 2021-01-18 17:24
 */
@Service
public class OrderServiceImpl extends BaseService implements OrderService {

    @Resource
    private KOrderMapper orderMapper;
    @Resource
    private KOrderItemMapper orderItemMapper;
    @Resource
    private KUserAddressMapper userAddressMapper;
    @Autowired
    private SnowFlakeComponent snowFlakeComponent;
    @Autowired
    private ProductService productService;


    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    @Override
    public String buyIt(BuyItParams params) {
        OrderServiceImpl selfObj = (OrderServiceImpl) AopContext.currentProxy();
        String orderId = snowFlakeComponent.str();
        BigDecimal price = null;
        Date now = new Date();
        //查询用户收货地址
        KUserAddress addressInfo = getDefaultUserAddressByUserId(params.getUserId());
        //查询商品信息
        KProduct productInfo = productService.getProductById(params.getProductId());
        A.notNull(productInfo, "商品信息不能为空");
        //查询商品规格信息
        KProductSpec specInfo = productService.getProductSpecById(params.getSpecId());
        if (specInfo != null) {
            A.of(specInfo.getStock() > 0, "商品库存不足");
            price = specInfo.getPrice().compareTo(productInfo.getShopPrice()) > 0 ? specInfo.getPrice() : productInfo.getShopPrice();
        }
        //DONE 添加订单信息
        KOrder order = new KOrder();
        order.setOrderId(orderId);
        order.setAddTime(now);
        order.setAmount(params.getAmount());
        order.setUserId(params.getUserId());
        order.setExpressPrice(productInfo.getMaterialsPrice());
        price = price == null ? productInfo.getShopPrice() : price;
        BigDecimal totalPrice = price.multiply(BigDecimal.valueOf(params.getAmount().longValue())).subtract(productInfo.getMaterialsPrice());
        order.setPayMoney(totalPrice);
        if (addressInfo != null) {
            order.setAddressId(addressInfo.getId());
        }

        //DONE 添加订单商品信息
        KOrderItem orderItem = new KOrderItem();
        orderItem.setAddTime(now);
        orderItem.setOrderId(orderId);
        orderItem.setSpecId(params.getSpecId());
        orderItem.setSpecTips(specInfo == null ? "" : specInfo.getTitle());
        orderItem.setpPrice(price);
        orderItem.setpAmount(params.getAmount());
        orderItem.setpName(productInfo.getName());
        orderItem.setpId(productInfo.getId());

        selfObj.saveOrderInfo(order);
        selfObj.saveOrderItem(orderItem);
        if (specInfo == null) {
            productService.updProductStock(params.getProductId(), params.getAmount());
        } else {
            productService.updProductSpecStock(params.getSpecId(), params.getAmount());
        }

        return orderId;
    }

    @Override
    public void addUserAddress(KUserAddress params) {
        KUserAddress record = new KUserAddress();
        record.setUserId(params.getUserId());
        List<KUserAddress> userAddress = userAddressMapper.select(record);
        if (params.getId() == null) {
            //添加
            params.setDef(userAddress.size() == 0 ? 1 : 0);
            if (userAddressMapper.insertSelective(params) != 1) {
                throw new E("添加地址失败");
            }
        } else {
            //修改
            if (userAddressMapper.updateByPrimaryKeySelective(params) != 1) {
                throw new E("修改地址失败");
            }
        }
    }

    @Override
    public List<KUserAddress> getUserAddressListByUserId(Long userId) {
        KUserAddress record = new KUserAddress();
        record.setUserId(userId);
        return userAddressMapper.select(record);
    }

    @Override
    public KOrder getOrderByOrderId(String orderId) {
        KOrder record = new KOrder();
        record.setOrderId(orderId);
        return orderMapper.selectOne(record);
    }

    @Override
    public void updOrderPayInfo(String orderId, Integer status, String transactionId) throws Exception {
        Example e = new Example(KOrder.class);
        Example.Criteria c = e.createCriteria();
        c.andEqualTo("orderId",orderId);
        KOrder record = new KOrder();
        record.setTransactionId(transactionId);
        record.setStatus(status);
        record.setPayTime(new Date());
        if (orderMapper.updateByExampleSelective(record,e)!=1) {
            logger.error("修改支付订单状态失败");
            throw new E("修改支付订单状态失败");
        }
    }

    @Transactional
    public void saveOrderItem(KOrderItem orderItem) {
        if (orderItemMapper.insertSelective(orderItem) != 1) {
            throw new E("添加订单商品信息失败");
        }
    }

    @Transactional
    public void saveOrderInfo(KOrder order) {
        if (orderMapper.insertSelective(order) != 1) {
            throw new E("添加订单信息失败");
        }
    }

    public KUserAddress getDefaultUserAddressByUserId(Long userId) {
        Example e = new Example(KUserAddress.class);
        Example.Criteria c = e.createCriteria();
        c.andEqualTo("userId", userId);
        c.andEqualTo("def", 1);
        KUserAddress userAddress = userAddressMapper.selectOneByExample(e);
        return userAddress == null || userAddress.getId() == null ? null : userAddress;
    }


}
