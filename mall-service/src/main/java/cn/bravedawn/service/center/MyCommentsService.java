package cn.bravedawn.service.center;

import cn.bravedawn.bo.center.OrderItemsCommentBO;
import cn.bravedawn.pojo.OrderItems;

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


    void saveComments(String orderId, String userId, List<OrderItemsCommentBO> commentList);

}
