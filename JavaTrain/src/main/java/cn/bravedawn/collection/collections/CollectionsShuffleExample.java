package cn.bravedawn.collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-02 15:09
 */
public class CollectionsShuffleExample {

    /**
     * 洗牌算法
     */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // 洗牌前
        System.out.println(list);

        // 洗牌后
        Collections.shuffle(list);
        System.out.println(list);
    }
}
