package cn.bravedawn.service.center;

import cn.bravedawn.bo.center.OrderItemsCommentBO;
import cn.bravedawn.pojo.OrderItems;
import cn.bravedawn.utils.PagedGridResult;

import java.util.List;

/**
 * @Author 冯晓
 * @Date 2020/3/28 15:00
 */
public interface MyCommentsService {

    /**
     * 根据订单id查询关联的商品
     * @param orderId
     * @return
     */
    List<OrderItems> queryPendingComment(String orderId);

    /**
     * 保存用户的评论
     * @param orderId
     * @param userId
     * @param commentList
     */
    void saveComments(String orderId, String userId, List<OrderItemsCommentBO> commentList);

    /**
     * 我的评价查询 分页
     * @param userId
     * @param page
     * @param pageSize
     * @return
     */
    public PagedGridResult queryMyComments(String userId, Integer page, Integer pageSize);

}
