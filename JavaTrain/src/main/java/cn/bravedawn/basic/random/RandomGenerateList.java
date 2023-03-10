package cn.bravedawn.basic.random;

import java.util.*;

public class RandomGenerateList {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(getDiffRandomList(10000, 999999));
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
    }


    /**
     * 生成 [0-size) 个不重复的随机数
     * @param size
     * @param bound
     * @return
     */
    public static Set<Integer> getDiffRandomList(int size, int bound){
        Set<Integer> set = new HashSet<>();
        Random rand = new Random();
        while (set.size() < size) {
            int num = rand.nextInt(bound);
            set.add(num);
        }
        return set;
    }

}
