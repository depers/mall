package cn.bravedawn.obj;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/21 17:18
 */
public class CloneExample3 implements Cloneable{

    private int a;
    private int b;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        CloneExample3 e1 = new CloneExample3();
        CloneExample3 e2 = (CloneExample3) e1.clone();
    }
}
