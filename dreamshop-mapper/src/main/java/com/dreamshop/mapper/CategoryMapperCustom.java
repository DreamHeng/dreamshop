package com.dreamshop.mapper;

import com.dreamshop.pojo.vo.CategoryVO;
import com.dreamshop.pojo.vo.NewItemsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryMapperCustom{

    List<CategoryVO> getSubCatList(Integer rootCatId);

    List<NewItemsVO> getSixNewItemsLazy(@Param("paramMap")Map map);
}
