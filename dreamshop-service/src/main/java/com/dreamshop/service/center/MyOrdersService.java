package com.dreamshop.service.center;

import com.dreamshop.pojo.Orders;
import com.dreamshop.pojo.vo.OrderStatusCountsVO;
import com.dreamshop.util.PagedGridResult;

/**
 * function:dreamshop
 *
 * @author DreamHeng
 * @date 2020/2/26
 */
public interface MyOrdersService {

    /**
     * function: 查询我的订单
     * @param userId
     * @param orderId
     * @return com.dreamshop.pojo.Orders
     */
    Orders queryMyOrder(String userId, String orderId);

    /**
     * function: 查询用户各种状态的订单数
     * @param userId
     * @return com.dreamshop.pojo.vo.OrderStatusCountsVO
     */
    OrderStatusCountsVO getOrderStatusCounts(String userId);

    /**
     * function: 查询我的订单列表
     * @param userId
     * @param orderStatus
     * @param page
     * @param pageSize
     * @return com.dreamshop.util.PagedGridResult
     */
    PagedGridResult queryMyOrders(String userId, Integer orderStatus, Integer page, Integer pageSize);

    /**
     * function: 订单状态 --> 商家发货
     * @param orderId
     * @return void
     */
    void updateDeliverOrderStatus(String orderId);

    /**
     * function: 更新订单状态 —> 确认收货
     * @param orderId
     * @return boolean
     */
    boolean updateReceiveOrderStatus(String orderId);

    /**
     * function: 删除订单（逻辑删除）
     * @param userId
     * @param orderId
     * @return boolean
     */
    boolean deleteOrder(String userId, String orderId);
}
