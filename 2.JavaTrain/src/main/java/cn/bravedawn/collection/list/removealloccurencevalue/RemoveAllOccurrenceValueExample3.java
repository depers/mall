package cn.bravedawn.collection.list.removealloccurencevalue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/21 12:58
 */
public class RemoveAllOccurrenceValueExample3 {


    /**
     * Collecting
     * 在之前的代码中我们都是使用移除的方式去去除特定值的所有元素
     * 其实，我们还可以创建一个新的list去保存我们想要的元素
     */


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        int valueToElement = 1;
        System.out.println(removeAll(list, valueToElement));
        System.out.println("--------------------------------------");

        List<Integer> list2 = new ArrayList<>(Arrays.asList(1, 2, 3));
        int valueToElement2 = 1;
        removeAll2(list2, valueToElement2);
        System.out.println(list2);
    }


    /**
     * 在下面的代码中，我们没有移除元素，而是返回了一个新的list(ArrayList)，可能与原始入参list的实现不同
     * 这里我们使用了for-each循环，但是我们并没有修改正在迭代的list
     */
    static List<Integer> removeAll(List<Integer> list, int element) {
        List<Integer> remainingElements = new ArrayList<>();
        for (Integer number : list) {
            if (!Objects.equals(number, element)) {
                remainingElements.add(number);
            }
        }
        return remainingElements;
    }


    /**
     * 在第二个实现中，为了保持原有入参list的实现，我们最后采用了clear()和addAll()方法将元素重新放到了入参中
     * 值得注意的是：只有两种可能的数组重新分配：当我们调用 List.clear() 和 List.addAll() 时
     */
    static void removeAll2(List<Integer> list, int element) {
        List<Integer> remainingElements = new ArrayList<>();
        for (Integer number : list) {
            if (!Objects.equals(number, element)) {
                remainingElements.add(number);
            }
        }
        list.clear();
        list.addAll(remainingElements);
    }
}
