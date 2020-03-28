package cn.bravedawn.mapper;

import cn.bravedawn.my.mapper.MyMapper;
import cn.bravedawn.pojo.ItemsComments;

import java.util.Map;

/**
 * @Author 冯晓
 * @Date 2020/3/28 15:48
 */
public interface ItemsCommentsMapperCustom extends MyMapper<ItemsComments> {

    void saveComments(Map<String, Object> map);
}
