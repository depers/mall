package cn.bravedawn.basic.lang.systemarraycopy;

import java.util.Arrays;

public class SystemArrayCopyExample2 {

    /**
     * System.arraycopy：
     * 深复制：当数组为一维数组，且元素为基本类型或String类型（String的特殊是因为它的不可变性）时，属于深复制，即原数组与新数组的元素不会相互影响
     */

    public static void main(String[] args) {
        String str1 = "aa";
        String str2 = "bb";
        String str3 = "cc";
        String str4 = "dd";

        // 一维数组
        String[] src = {str1, str2, str3, str4};
        String[] dest = new String[4];
        System.arraycopy(src, 0, dest, 0, 4);

        System.out.println("改变前");
        print("src = ", src);
        print("dest = ", dest);

        src[0] = "abcd";

        System.out.println("改变后");
        print("src = ", src);
        print("dest = ", dest);
    }

    private static void print(String string, String[] arr) {
        System.out.print(string);
        for (String str : arr) {
            System.out.print(str + " ");
        }
        System.out.println();
    }
}
