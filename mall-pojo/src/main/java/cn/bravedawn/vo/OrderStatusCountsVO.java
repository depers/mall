package cn.bravedawn.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 订单状态概览数量VO
 * @Author 冯晓
 * @Date 2020/3/28 16:41
 */
@Data
@AllArgsConstructor
public class OrderStatusCountsVO {

    private Integer waitPayCounts;
    private Integer waitDeliverCounts;
    private Integer waitReceiveCounts;
    private Integer waitCommentCounts;
}
