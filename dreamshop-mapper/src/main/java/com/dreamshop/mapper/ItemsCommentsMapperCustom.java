package com.dreamshop.mapper;

import com.dreamshop.pojo.vo.MyCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * function:dreamshop
 *
 * @author DreamHeng
 * @date 2020/2/27
 */
public interface ItemsCommentsMapperCustom {

    void saveComments(Map<String, Object> map);

    List<MyCommentVO> queryMyComments(@Param("paramsMap") Map<String, Object> map);
}
