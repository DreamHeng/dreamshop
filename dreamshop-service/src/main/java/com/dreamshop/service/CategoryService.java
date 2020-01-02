package com.dreamshop.service;

import com.dreamshop.pojo.Category;
import com.dreamshop.pojo.vo.CategoryVO;
import com.dreamshop.pojo.vo.NewItemsVO;

import java.util.List;

/**
 * @author DreamHeng
 * @date 2020/1/1
 */
public interface CategoryService {

    /**
     * function:查询所有一级分类
     * @return
     */
    List<Category> queryAllRootLevelCat();

    /**
     * function:根据一级分类id查询子分类信息
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);

    /**
     * function:根据以及分类id获取其下最新六个商品的简单信息
     * @param rootCatId
     * @return
     */
    List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId);

}
