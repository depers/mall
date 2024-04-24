package cn.bravedawn.basic.lang.systemarraycopy;

public class SystemArrayCopyExample5 {

    /**
     * System.arraycopy异常：ArrayIndexOutOfBoundsException(IndexOutOfBoundsException)
     */



    public static void main(String[] args) {
        // testOne();

        // testTwo();

        testThree();
    }

    /**
     * The srcPos argument is negative.
     * The destPos argument is negative.
     * The length argument is negative.
     */
    static void testOne() {
        int[] src = {1, 2, 3, 4};
        int[] dest = new int[5];
        System.arraycopy(src, -1, dest, 0, 0);

        for (Object o : dest) {
            System.out.println(o);
        }
    }


    /**
     * srcPos+length is greater than src.length, the length of the source array.
     */
    static void testTwo() {
        int[] src = {1, 2, 3, 4};
        int[] dest = new int[5];
        System.arraycopy(src, 1, dest, 0, 4);

        for (Object o : dest) {
            System.out.println(o);
        }
    }

    /**
     * destPos+length is greater than dest.length, the length of the destination array.
     */
    static void testThree() {
        int[] src = {1, 2, 3, 4};
        int[] dest = new int[3];
        System.arraycopy(src, 0, dest, 0, 4);

        for (Object o : dest) {
            System.out.println(o);
        }
    }


}
