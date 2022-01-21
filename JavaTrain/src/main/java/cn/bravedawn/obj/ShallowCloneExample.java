package cn.bravedawn.obj;

import java.util.Arrays;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/21 17:21
 */
public class ShallowCloneExample implements Cloneable{

    /**
     * 拷贝对象和原始对象的属性的引用类型引用的是同一个对象。
     */

    private int[] arr;

    public ShallowCloneExample() {
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
    protected ShallowCloneExample clone() throws CloneNotSupportedException {
        return (ShallowCloneExample) super.clone();
    }


    public static void main(String[] args) {
        ShallowCloneExample e1 = new ShallowCloneExample();
        ShallowCloneExample e2 = null;

        try {
            // 克隆后e1和e2是两个实例变量其实引用的是不同的对象引用
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
        System.out.println(e1.arr.equals(e2.arr)); // true
        System.out.println(e1.arr.hashCode() == e2.arr.hashCode()); // true
    }
}
