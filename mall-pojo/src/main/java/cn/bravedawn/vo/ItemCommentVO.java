package cn.bravedawn.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author 冯晓
 * @Date 2020/1/13 22:10
 * @Title 用于展示商品评价的VO
 */
@Data
public class ItemCommentVO {

    private Integer commentLevel;
    private String content;
    private String specName;
    private Date createdTime;
    private String userFace;
    private String nickname;
}
