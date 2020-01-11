package com.dreamshop.mapper;

import com.dreamshop.pojo.vo.ItemCommentVO;
import com.dreamshop.pojo.vo.SearchItemsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author DreamHeng
 * @date 2020/1/9
 */
public interface ItemsMapperCustom {

    List<ItemCommentVO> queryItemComments(@Param("paramsMap") Map<String, Object> map);

    List<SearchItemsVO> searchItems(@Param("paramsMap") Map<String, Object> map);

    List<SearchItemsVO> searchItemsByThirdCat(@Param("paramsMap") Map<String, Object> map);
}
