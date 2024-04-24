package cn.bravedawn.basic.lang.systemarraycopy;

public class SystemArrayCopyExample4 {

    /**
     * System.arraycopy：
     * 浅复制：当数组为多维数组，或一维数组中的元素为引用类型时，属于浅复制，原数组与新数组的元素引用指向同一个对象
     */

    public static void main(String[] args) {
        People p1 = new People(11, "A");
        People p2 = new People(12, "B");
        People p3 = new People(13, "C");
        People p4 = new People(14, "D");

        // 一维数组的元素为引用类型
        People[] src = {p1, p2, p3, p4};
        People[] dest = new People[4];

        System.arraycopy(src, 0, dest, 0, 4);

        System.out.println("改变前");
        print("src = ", src);
        print("dest = ", dest);

        src[0].setAge(111);
        src[0].setName("AAA");

        System.out.println("改变后");
        print("src = ", src);
        print("dest = ", dest);
    }

    private static void print(String string, People[] arr) {
        System.out.print(string);
        for (People p : arr) {
            System.out.print(p + ", ");
        }
        System.out.println();
    }
}
