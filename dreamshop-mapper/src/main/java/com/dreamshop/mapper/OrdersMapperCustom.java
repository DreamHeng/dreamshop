package com.dreamshop.mapper;

import com.dreamshop.pojo.OrderStatus;
import com.dreamshop.pojo.vo.MyOrdersVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * function:dreamshop
 *
 * @author DreamHeng
 * @date 2020/2/26
 */
public interface OrdersMapperCustom {
    List<MyOrdersVO> queryMyOrders(@Param("paramsMap") Map<String, Object> map);

    int getMyOrderStatusCounts(@Param("paramsMap") Map<String, Object> map);

    List<OrderStatus> getMyOrderTrend(@Param("paramsMap") Map<String, Object> map);

}
