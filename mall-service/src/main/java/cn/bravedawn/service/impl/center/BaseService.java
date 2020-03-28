package cn.bravedawn.service.impl.center;

import cn.bravedawn.utils.PagedGridResult;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Author 冯晓
 * @Date 2020/3/28 9:56
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
