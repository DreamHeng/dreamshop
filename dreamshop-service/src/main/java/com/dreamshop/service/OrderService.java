package com.dreamshop.service;

import com.dreamshop.pojo.bo.SubmitOrderBO;
import com.dreamshop.pojo.vo.OrderVO;

/**
 * function:dreamshop
 *
 * @author DreamHeng
 * @date 2020/2/3
 */
public interface OrderService {

    /**
     * function: 创建订单相关信息
     * @param submitOrderBO
     * @return com.dreamshop.pojo.vo.OrderVO
     */
    OrderVO createOrder(SubmitOrderBO submitOrderBO);
}
