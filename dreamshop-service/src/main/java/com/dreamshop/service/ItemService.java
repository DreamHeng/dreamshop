package com.dreamshop.service;

import com.dreamshop.pojo.*;

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
}
