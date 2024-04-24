package cn.bravedawn.collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-02 15:31
 */
public class CollectionsUnmodifiableExample {

    /**
     * 将已有集合转变为不可变集合
     */

    public static void main(String[] args) {
        createUnmodifiableList();
    }


    public static void createUnmodifiableList() {
        List<String> mutable = new ArrayList<>();
        mutable.add("apple");
        mutable.add("pear");

        // 变为不可变集合
        List<String> immutable = Collections.unmodifiableList(mutable);
        immutable.add("orange"); // UnsupportedOperationException
    }




}
