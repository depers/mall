package cn.bravedawn.obj;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/21 17:15
 */
public class CloneExample2 {

    /**
     * 抛出了 CloneNotSupportedException，这是因为 CloneExample 没有实现 Cloneable 接口
     */

    private int a;
    private int b;

    public static void main(String[] args) {
        CloneExample2 e1 = new CloneExample2();
        try {
            CloneExample2 e2 = e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace(); // java.lang.CloneNotSupportedException: cn.bravedawn.obj.CloneExample2
        }
    }

    @Override
    protected CloneExample2 clone() throws CloneNotSupportedException {
        return (CloneExample2) super.clone();
    }
}
