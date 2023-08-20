package cn.bravedawn.basic.lang.systemarraycopy;

public class SystemArrayCopyExample3 {

    /**
     * System.arraycopy：
     * 浅复制：当数组为多维数组，或一维数组中的元素为引用类型时，属于浅复制，原数组与新数组的元素引用指向同一个对象
     */

    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        int[] arr3 = {5, 6};
        int[] arr4 = {7, 8};

        // 多维数组
        int[][] src = new int[][]{arr1, arr2, arr3, arr4};
        int[][] dest = new int[4][];

        System.arraycopy(src, 0, dest, 0, 4);

        System.out.println("改变前");
        print("src = ", src);
        print("dest = ", dest);

        src[0][0] = 11111;

        System.out.println("改变后");
        print("src = ", src);
        print("dest = ", dest);
    }

    private static void print(String string, int[][] arr) {
        System.out.print(string);
        for (int[] a : arr) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.print(",");
        }
        System.out.println();
    }
}
