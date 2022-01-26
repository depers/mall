package cn.bravedawn.obj.object;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/21 17:12
 */
public class CloneExample {

    /**
     * clone() 是 Object 的 protected 方法，它不是 public
     */

    private int a;
    private int b;


    public static void main(String[] args) {
        CloneExample example = new CloneExample();
        // CloneExample example2 = example.clone(); // 'clone()' has protected access in 'java.lang.Object'
    }
}
