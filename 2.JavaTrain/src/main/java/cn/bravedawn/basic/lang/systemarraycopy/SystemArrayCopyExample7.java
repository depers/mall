package cn.bravedawn.basic.lang.systemarraycopy;

public class SystemArrayCopyExample7 {

    /**
     * System.arraycopy异常：NullPointerException
     *
     * If dest is null, then a NullPointerException is thrown.
     * If src is null, then a NullPointerException is thrown and the destination array is not modified.
     */



    public static void main(String[] args) {
        int[] src = {1, 2, 3, 4};
        int[] dest = null;
        System.arraycopy(src, 0, dest, 0, 4);

        for (Object o : dest) {
            System.out.println(o);
        }

    }





}
