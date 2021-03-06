package com.dreamshop.service;

import com.dreamshop.pojo.*;
import com.dreamshop.pojo.vo.CommentLevelCountsVO;
import com.dreamshop.pojo.vo.ShopcatVO;
import com.dreamshop.util.PagedGridResult;

import java.util.List;

/**
 * @author DreamHeng
 * @date 2020/1/2
 */
public interface ItemService {

    /**
     * function:根据商品id查询商品详情
     * @return
     */
    Items queryItemById(String itemId);

    /**
     * function:根据商品id查询商品图片
     * @param itemId
     * @return
     */
    List<ItemsImg> queryItemImgList(String itemId);

    /**
     * function:根据商品id查询商品规格
     * @param itemId
     * @return
     */
    List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * function:根据商品id查询商品参数
     * @param itemId
     * @return
     */
    ItemsParam queryItemParams(String itemId);

    /**
     * function:根据商品id查询商品的评价等级数量
     * @param itemId
     * @return
     */
    CommentLevelCountsVO queryCommentCounts(String itemId);

    /**
     * function:根据商品id查询商品评价（分页）
     * @param itemId
     * @param level
     * @param page
     * @param size
     * @return com.dreamshop.util.PagedGridResult
     */
    PagedGridResult queryPagedComments(String itemId, Integer level,
                                       Integer page, Integer size);

    /**
     * function:搜索商品列表
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return com.dreamshop.util.PagedGridResult
     */
    PagedGridResult searchItems(String keywords, String sort,
                               Integer page, Integer pageSize);

    /**
     * function:根据分类id搜索商品列表
     * @param catId
     * @param sort
     * @param page
     * @param pageSize
     * @return com.dreamshop.util.PagedGridResult
     */
    PagedGridResult searchItems(Integer catId, String sort,
                               Integer page, Integer pageSize);

    /**
     * function:根据规格ids查询最新的购物车中商品数据（用于刷新渲染购物车中的商品数据）
     * @param specIds
     * @return java.util.List<com.dreamshop.pojo.vo.ShopcatVO>
     */
    List<ShopcatVO> queryItemsBySpecIds(String specIds);

    /**
     * function:根据商品规格id获取规格对象的具体信息
     * @param specId
     * @return com.dreamshop.pojo.ItemsSpec
     */
    ItemsSpec queryItemSpecById(String specId);

    /**
     * function: 根据图片id获得商品主图url
     * @param itemId
     * @return java.lang.String
     */
    String queryItemMainImgById(String itemId);

    /**
     * function: 根据商品id扣除商品库存
     * @param itemSpecId
     * @param buyCounts
     * @return void
     */
    void decreaseItemSpecStock(String itemSpecId, int buyCounts);
}
