package cn.bravedawn.basic.lang.systemarraycopy;

import java.util.Arrays;

public class SystemArrayCopyExample {

    /**
     * System.arraycopy的简单使用
     */

    public static void main(String[] args) {
        int[] src = {1, 2, 3, 4};
        int[] dest = new int[5];

        System.arraycopy(src, 0, dest, 0, 4);

        Arrays.stream(dest).forEach(i -> System.out.println(i));
    }
}
