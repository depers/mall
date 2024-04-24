package cn.bravedawn.collection.list.unsupportedoperationexception;

import java.util.Arrays;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/17 16:26
 */
public class UnsupportedOperationExceptionExample {

    /**
     * 这个报错的原因是返回的对象没有实现add()操作，因为他与java.util.ArrayList不同，他是 java.util.Arrays.ArrayList的对象
     */

    public static void main(String[] args) {
        String[] flowers = { "Ageratum", "Allium", "Poppy", "Catmint" };
        List<String> flowerList = Arrays.asList(flowers);
        flowerList.add("Celosia"); // java.lang.UnsupportedOperationException

    }
}
