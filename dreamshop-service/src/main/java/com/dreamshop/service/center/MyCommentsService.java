package com.dreamshop.service.center;

import com.dreamshop.pojo.OrderItems;
import com.dreamshop.pojo.bo.center.OrderItemsCommentBO;
import com.dreamshop.util.PagedGridResult;

import java.util.List;

/**
 * function:dreamshop
 *
 * @author DreamHeng
 * @date 2020/2/27
 */
public interface MyCommentsService {

    /**
     * function: 根据订单id查询关联到的商品
     * @param orderId
     * @return java.util.List<com.dreamshop.pojo.OrderItems>
     */
    List<OrderItems> queryPendingComment(String orderId);

    /**
     * function: 保存用户的评论
     * @param orderId
     * @param userId
     * @param commentList
     * @return void
     */
    void saveComments(String orderId, String userId, List<OrderItemsCommentBO> commentList);

    /**
     * function: 查询我的评价，分页
     * @param userId
     * @param page
     * @param pageSize
     * @return com.dreamshop.util.PagedGridResult
     */
    PagedGridResult queryMyComments(String userId, Integer page, Integer pageSize);
}
