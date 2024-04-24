package cn.bravedawn.collection.collections;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/27 15:25
 */
public class CollectionsGetImmutableListExample {

    /**
     * 集合类基本上包含如下所示的3个字段，可用于返回不可变实体
     */

    public static void main(String[] args) {
        List<Integer> list = Collections.EMPTY_LIST;
        Map<String, Integer> map = Collections.EMPTY_MAP;
        Set<Integer> set = Collections.EMPTY_SET;

        list.add(1);     // UnsupportedOperationException
        map.put("a", 1); // UnsupportedOperationException
        set.add(2);      // UnsupportedOperationException
    }
}
