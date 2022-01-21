package cn.bravedawn.obj;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/21 17:49
 */
public class CloneConstructorExample {

    /**
     *  最好不要去使用 clone()，可以使用拷贝构造函数或者拷贝工厂来拷贝一个对象
     *  使用 clone() 方法来拷贝一个对象即复杂又有风险，它会抛出异常，并且还需要类型转换
     */


    private int[] arr;

    public CloneConstructorExample() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }


    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }


    /**
     * 拷贝构造函数
     * @param original
     */
    public CloneConstructorExample(CloneConstructorExample original) {
        arr = new int[original.arr.length];
        for (int i = 0; i < original.arr.length; i++) {
            arr[i] = original.arr[i];
        }
    }

}
