package cn.bravedawn.vo;

import lombok.Data;

/**
 * 用于展示商品评价数量的vo
 * @Author 冯晓
 * @Date 2020/1/7 14:45
 */
@Data
public class CommentLevelCountsVO {

    private Integer totalCounts;
    private Integer goodCounts;
    private Integer normalCounts;
    private Integer badCounts;
}
