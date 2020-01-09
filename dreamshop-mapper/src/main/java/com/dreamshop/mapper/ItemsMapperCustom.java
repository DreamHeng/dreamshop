package com.dreamshop.mapper;

import com.dreamshop.pojo.vo.ItemCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author DreamHeng
 * @date 2020/1/9
 */
public interface ItemsMapperCustom {
    List<ItemCommentVO> queryItemComments(@Param("paramsMap") Map<String, Object> map);

}
