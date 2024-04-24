package cn.bravedawn.generic.genericarray;

import java.lang.reflect.Array;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/2/25 21:30
 */
public class GenericArray<T> {

    /**
     * 泛型数组
     * 一般不建议创建泛型数组。尽量使用ArrayList来代替泛型数组。但是在这里还是给出一种创建泛型数组的方法
     */

    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type, size);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T[] rep() {
        return array;
    }


}
