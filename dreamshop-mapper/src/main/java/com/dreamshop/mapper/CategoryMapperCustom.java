package com.dreamshop.mapper;

import com.dreamshop.pojo.vo.CategoryVO;

import java.util.List;

public interface CategoryMapperCustom{

    List<CategoryVO> getSubCatList(Integer rootCatId);
}
