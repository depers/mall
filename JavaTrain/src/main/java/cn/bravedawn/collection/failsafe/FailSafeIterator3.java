package cn.bravedawn.collection.failsafe;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/3/28 20:09
 */
public class FailSafeIterator3 {

    /**
     * Fail-safe示例：使用 Iterator 删除（推荐）
     */

    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("emma");
        students.add("paul");
        students.add("walker");
        students.add("elanie");
        students.add("amara");

        Iterator iterator = students.iterator();

        while (iterator.hasNext()) {
            // 这里next方法会抛出异常
            if (((String) iterator.next()).equals("paul")) {
                iterator.remove();
            }
        }

        System.out.println(students);

    }
}
