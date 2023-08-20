package cn.bravedawn.collection.list.removealloccurencevalue;

import java.util.*;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/20 19:20
 */
public class RemoveAllOccurrenceValueExample2 {

    /**
     * 使用for循环，for-each循环，Iterator循环删除所有的特定值的元素
     * 存在严重的性能问题：
     *      从 ArrayList 中删除一个元素，移动它之后的所有项目
     *      在 LinkedList 中通过索引访问元素意味着一个接一个地遍历元素，直到找到索引，然后才能通过索引删除它，尽管删除很快
     *
     */


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        int valueToElement = 1;
        removeAll(list, valueToElement);

        System.out.println("---------------------------------------");
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        int valueToElement2 = 1;
        //removeAll2(list2, valueToElement2);

        System.out.println("---------------------------------------");
        List<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3));
        int valueToElement3 = 1;
        removeAll3(list3, valueToElement3);
    }

    /**
     * 实验一：使用for循环来移除元素
     * 实验过程：
     *      这里会遇到RemoveAllOccurrenceValueExample实验一中的情况类似
     */
    static void removeAll(List<Integer> list, int element) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(element, list.get(i))) {
                list.remove(element);
            }
        }
        System.out.println(list);
    }

    /**
     * 实验二：使用for-each来移除元素
     * for-each 循环使用 Iterator 遍历元素。 但是，当我们修改List时，Iterator会进入不一致的状态。
     * 因此它抛出 ConcurrentModificationException。
     */
    static void removeAll2(List<Integer> list, int element) {
        for (Integer el : list) {
            if (Objects.equals(element, el)) {
                list.remove(el); // java.util.ConcurrentModificationException
            }
        }
        System.out.println(list);
    }


    /**
     * 实验三：使用Iterator遍历list并修改它
     * 实验过程:
     *      Iterator可以按照预期的效果执行代码，由于每个 List 类都可以提供自己的 Iterator 实现，
     *      我们可以放心地假设它以最有效的方式实现元素遍历和删除。
     *      使用 ArrayList 仍然意味着大量的元素移动（可能还有数组重新分配）
     */
    static void removeAll3(List<Integer> list, int element) {
        for (Iterator<Integer> i = list.iterator(); i.hasNext();) {
            Integer number = i.next();
            if (Objects.equals(number, element)) {
                i.remove();
            }
        }
        System.out.println(list);
    }



}
