package com.dreamshop.service;

import com.dreamshop.pojo.Category;
import com.dreamshop.pojo.vo.CategoryVO;

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
     * function:分局一级分类id查询子分类信息
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);

}
