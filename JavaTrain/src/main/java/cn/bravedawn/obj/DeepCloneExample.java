package cn.bravedawn.obj;

import java.util.Arrays;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/21 17:35
 */
public class DeepCloneExample implements Cloneable {

    /**
     * 拷贝对象和原始对象的属性的引用类型引用是不同对象
     */


    private int[] arr;

    public DeepCloneExample() {
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

    public void printArr() {
        System.out.println(Arrays.toString(this.arr));
    }


    @Override
    protected DeepCloneExample clone() throws CloneNotSupportedException {
        DeepCloneExample result = (DeepCloneExample) super.clone();
        // 手动翻写arr对象
        result.arr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result.arr[i] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        DeepCloneExample e1 = new DeepCloneExample();
        DeepCloneExample e2 = null;

        try {
            e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // 修改之前打印
        System.out.println("修改之前打印------------");
        e1.printArr();
        e2.printArr();

        e1.set(2, 222);

        // 修改之后打印
        System.out.println("修改之后打印------------");
        e1.printArr();
        e2.printArr();

        // equals方法
        System.out.println("打印对象的本身");
        System.out.println(e1.equals(e2)); // false
        System.out.println(e1.hashCode() == e2.hashCode()); // false

        System.out.println("打印对象的属性");
        System.out.println(e1.arr.equals(e2.arr)); // false
        System.out.println(e1.arr.hashCode() == e2.arr.hashCode()); // false
    }

}
