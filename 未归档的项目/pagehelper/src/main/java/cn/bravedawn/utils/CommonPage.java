package cn.bravedawn.utils;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author : depers
 * @program : pagehelper
 * @description:
 * @date : Created in 2022/1/5 17:06
 */
public class CommonPage<T> {

    private String pageNum;
    private String pageSize;
    private String totalPage;
    private String total;
    private List<T> list;

    public static <P, V> CommonPage<V> resetPage(PageInfo<P> poList, List<V> voList) {
        CommonPage<V> result = new CommonPage<>();
        result.setPageNum(String.valueOf(poList.getPageNum()));
        result.setPageSize(String.valueOf(poList.getPageSize()));
        result.setTotalPage(String.valueOf(poList.getPages()));
        result.setTotal(String.valueOf(poList.getTotal()));
        result.setList(voList);
        return result;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
