package cn.bravedawn.mapper;

import cn.bravedawn.vo.ItemCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author 冯晓
 * @Date 2020/1/13 22:15
 */
public interface ItemsMapperCustom {

    /**
     * 查询商品的用户评价
     * @param map
     * @return
     */
    List<ItemCommentVO> queryItemComments(@Param("paramsMap") Map<String, Object> map);
}
