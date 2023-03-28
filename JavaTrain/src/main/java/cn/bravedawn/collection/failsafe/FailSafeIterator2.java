package cn.bravedawn.collection.failsafe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/3/28 20:25
 */
public class FailSafeIterator2 {

    /**
     * Fail-safe迭代器示例：CopyOnWriteArrayList
     * 可以参考：cn.bravedawn.collection.list.copyonwritearraylist.CopyOnWriteArrayListExample
     */

    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("emma");
        students.add("paul");
        students.add("walker");
        students.add("elanie");
        students.add("amara");

        CopyOnWriteArrayList<String> copyList = new CopyOnWriteArrayList<>(students);

        Iterator itr = copyList.iterator();

        while (itr.hasNext()) {
            String name = (String) itr.next();
            System.out.println(name);

            copyList.add("rubby");
        }
    }
}
