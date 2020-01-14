package cn.bravedawn.service;

import cn.bravedawn.pojo.Items;
import cn.bravedawn.pojo.ItemsImg;
import cn.bravedawn.pojo.ItemsParam;
import cn.bravedawn.pojo.ItemsSpec;
import cn.bravedawn.utils.PagedGridResult;
import cn.bravedawn.vo.CommentLevelCountsVO;

import java.util.List;

/**
 * @Author 冯晓
 * @Date 2020/1/7 10:49
 */
public interface ItemService {

    /**
     * 根据商品ID查询详情
     * @param itemId
     * @return
     */
    Items queryItemById(String itemId);

    /**
     * 根据商品id查询商品图片列表
     * @param itemId
     * @return
     */
    List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品id查询商品规格
     * @param itemId
     * @return
     */
    List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品id查询商品参数
     * @param itemId
     * @return
     */
    ItemsParam queryItemParam(String itemId);

    /**
     * 根据商品id查询商品的评价等级数量
     * @param itemId
     */
    CommentLevelCountsVO queryCommentCounts(String itemId);


    /**
     * 根据商品id查询商品的评价（分页）
     * @param itemId
     * @param level
     * @return
     */
    PagedGridResult queryPagedComments(String itemId, Integer level,
                                       Integer page, Integer pageSize);

    /**
     * 搜索商品列表
     * @param keywords
     * @param sort
     * @param page
     * @param pageSize
     * @return
     */
    PagedGridResult searchItems(String keywords, String sort,
                                      Integer page, Integer pageSize);
}
