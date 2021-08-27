package cn.bravedawn.shardingjdbcdemo.dao;

import cn.bravedawn.shardingjdbcdemo.model.OrderItem;
import cn.bravedawn.shardingjdbcdemo.model.OrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface OrderItemMapper {
    long countByExample(OrderItemExample example);

    int deleteByExample(OrderItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    int insertSelective(OrderItem record);

    List<OrderItem> selectByExample(OrderItemExample example);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderItem record, @Param("example") OrderItemExample example);

    int updateByExample(@Param("record") OrderItem record, @Param("example") OrderItemExample example);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    @Select("select oi.* from orders o INNER JOIN order_item oi ON o.user_id = oi.user_id AND o.order_id = oi.order_id where o.order_id = #{orderId}")
    List<OrderItem> selectByOrderIdAndUserId(@Param("orderId") int orderId);
}