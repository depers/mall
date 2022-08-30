package cn.bravedawn.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author : depers
 * @program : pagehelper
 * @description:
 * @date : Created in 2022/1/5 13:55
 */
public class PageUtils {

    /**
     * 参考：https://www.cnblogs.com/zhangshuaiyin/p/12038087.html
     * 将PageInfo对象泛型中的Po对象转化为Vo对象
     * @param pageInfoPo PageInfo<Po>对象</>
     * @param <P> Po类型
     * @param <V> Vo类型
     * @return
     */
    public static <P, V> PageInfo<V> PageInfo2PageInfoVo(PageInfo<P> pageInfoPo, List<V> listVo) {
        // 创建Page对象，实际上是一个ArrayList类型的集合
        Page<V> page = new Page<>(pageInfoPo.getPageNum(), pageInfoPo.getPageSize());
        page.setTotal(pageInfoPo.getTotal());
        PageInfo<V> pageInfo = new PageInfo<>(page);
        pageInfo.setList(listVo);
        return pageInfo;
    }
}
