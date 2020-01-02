package com.dreamshop.service.impl;

import com.dreamshop.mapper.ItemsImgMapper;
import com.dreamshop.mapper.ItemsMapper;
import com.dreamshop.mapper.ItemsParamMapper;
import com.dreamshop.mapper.ItemsSpecMapper;
import com.dreamshop.pojo.Items;
import com.dreamshop.pojo.ItemsImg;
import com.dreamshop.pojo.ItemsParam;
import com.dreamshop.pojo.ItemsSpec;
import com.dreamshop.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author DreamHeng
 * @date 2020/1/2
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemsMapper itemsMapper;
    @Autowired
    private ItemsImgMapper itemsImgMapper;
    @Autowired
    private ItemsSpecMapper itemsSpecMapper;
    @Autowired
    private ItemsParamMapper itemsParamMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Items queryItemById(String itemId) {
        return itemsMapper.selectByPrimaryKey(itemId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsImg> queryItemImgList(String itemId) {
        ItemsImg itemsImg = new ItemsImg();
        itemsImg.setItemId(itemId);
        return itemsImgMapper.select(itemsImg);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<ItemsSpec> queryItemSpecList(String itemId) {
        ItemsSpec itemsSpec = new ItemsSpec();
        itemsSpec.setItemId(itemId);
        return itemsSpecMapper.select(itemsSpec);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ItemsParam queryItemParams(String itemId) {
        ItemsParam itemsParam = new ItemsParam();
        itemsParam.setItemId(itemId);
        return itemsParamMapper.selectOne(itemsParam);
    }
}
