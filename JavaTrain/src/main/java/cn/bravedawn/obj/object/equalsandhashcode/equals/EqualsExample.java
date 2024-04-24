package cn.bravedawn.obj.object.equalsandhashcode.equals;

import java.util.Objects;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/21 16:50
 */
public class EqualsExample {

    /**
     * equals方法的实现
     * 在覆盖 equals() 方法时应当总是覆盖 hashCode() 方法，保证等价的两个对象散列值也相等。
     */

    private int x;
    private int y;
    private int z;

    public EqualsExample(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        // 1.检查是否为同一个对象的引用，如果是直接返回 true；
        if (this == o) return true;

        // 2.检查是否是同一个类型，如果不是，直接返回 false；
        if (o == null || getClass() != o.getClass()) return false;

        // 3.将 Object 对象进行转型；
        EqualsExample that = (EqualsExample) o;

        // 4.判断每个关键域是否相等；
        return x == that.x && y == that.y && z == that.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "EqualsExample{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
