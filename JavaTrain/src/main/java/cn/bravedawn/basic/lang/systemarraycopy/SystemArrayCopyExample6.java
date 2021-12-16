package cn.bravedawn.basic.lang.systemarraycopy;

public class SystemArrayCopyExample6 {

    /**
     * System.arraycopy异常：ArrayStoreException，这种主要是源数组和目标数组的类型不匹配导致的
     * The src argument refers to an object that is not an array.
     * The dest argument refers to an object that is not an array.
     * The src argument and dest argument refer to arrays whose component types are different primitive types.
     * The src argument refers to an array with a primitive component type and the dest argument refers to an array with a reference component type.
     * The src argument refers to an array with a reference component type and the dest argument refers to an array with a primitive component type.
     */



    public static void main(String[] args) {
        testOne();

        // testTwo();
    }


    /**
     * The src argument refers to an array with a primitive component type and the dest argument refers to an array with a reference component type.
     */
    static void testOne() {
        int[] src = {1, 2, 3, 4};
        Object[] dest = new Object[3];
        System.arraycopy(src, 0, dest, 0, 4);

        for (Object o : dest) {
            System.out.println(o);
        }
    }


    /**
     * The src argument refers to an array with a reference component type and the dest argument refers to an array with a primitive component type.
     */
    static void testTwo() {
        Object[] src = {1, 2, 3, 4};
        int[] dest = new int[3];
        System.arraycopy(src, 0, dest, 0, 4);

        for (Object o : dest) {
            System.out.println(o);
        }
    }





}
