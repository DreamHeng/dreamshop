package com.dreamshop.service.impl;

import com.dreamshop.mapper.CategoryMapper;
import com.dreamshop.mapper.CategoryMapperCustom;
import com.dreamshop.pojo.Category;
import com.dreamshop.pojo.vo.CategoryVO;
import com.dreamshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author DreamHeng
 * @date 2020/1/1
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CategoryMapperCustom categoryMapperCustom;

    @Override
    public List<Category> queryAllRootLevelCat() {
        Example categoryExample = new Example(Category.class);
        Example.Criteria criteria = categoryExample.createCriteria();
        criteria.andEqualTo("type",1);

        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        return categories;
    }

    @Override
    public List<CategoryVO> getSubCatList(Integer rootCatId) {
        return categoryMapperCustom.getSubCatList(rootCatId);
    }
}
