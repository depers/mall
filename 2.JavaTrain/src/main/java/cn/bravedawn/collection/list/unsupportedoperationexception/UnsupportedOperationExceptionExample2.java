package cn.bravedawn.collection.list.unsupportedoperationexception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/17 16:34
 */
public class UnsupportedOperationExceptionExample2 {

    /**
     * 对不可变列表进行修改操作时，会抛出 java.lang.UnsupportedOperationException
     */

    public static void main(String[] args) {
        String[] flowers = {"Ageratum", "Allium", "Poppy", "Catmint"};
        List<String> flowerList = new ArrayList<>(Arrays.asList(flowers));
        List<String> immutableList = Collections.unmodifiableList(flowerList);
        immutableList.remove(0);
    }
}
