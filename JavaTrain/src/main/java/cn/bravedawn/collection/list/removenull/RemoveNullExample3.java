package cn.bravedawn.collection.list.removenull;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.PredicateUtils;

import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/16 10:50
 */
public class RemoveNullExample3 {

    /**
     * 使用Apache commons Collections 移除null元素，会直接修改原列表
     */

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(null, 1, 2, null, 3, null);
        CollectionUtils.filter(list, PredicateUtils.notNullPredicate());
        System.out.println(list); // [1, 2, 3]
    }
}
