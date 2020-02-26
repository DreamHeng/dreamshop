package com.dreamshop.service.impl.center;

import com.dreamshop.util.PagedGridResult;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * function:dreamshop
 *
 * @author DreamHeng
 * @date 2020/2/26
 */
public class BaseService {
    public PagedGridResult setterPagedGrid(List<?> list, Integer page) {
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult grid = new PagedGridResult();
        grid.setPage(page);
        grid.setRows(list);
        grid.setTotal(pageList.getPages());
        grid.setRecords(pageList.getTotal());
        return grid;
    }
}
