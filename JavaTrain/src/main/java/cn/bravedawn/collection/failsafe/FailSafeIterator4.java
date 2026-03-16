package cn.bravedawn.collection.failsafe;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/3/28 20:09
 */
public class FailSafeIterator4 {

    /**
     * Fail-safe示例：Java8+ 最优雅写法（推荐）
     */

    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("emma");
        students.add("paul");
        students.add("walker");
        students.add("elanie");
        students.add("amara");

        students.removeIf(item -> item.equals("paul"));

        System.out.println(students);

    }
}
