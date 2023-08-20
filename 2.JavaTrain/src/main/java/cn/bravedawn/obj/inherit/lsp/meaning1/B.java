package cn.bravedawn.obj.inherit.lsp.meaning1;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/1/24 14:35
 */
public class B extends A{

    @Override
    public void fun(int a, int b) {
        System.out.println(a + "-" + b + "=" + (a-b));
    }
}
