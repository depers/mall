package cn.bravedawn.obj.inherit.this_.abstract_;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/7/24 21:51
 *
 * this指代真正的实现类
 */
public abstract class Uti {

    public void packing() {
        System.out.println("开始制作");
        Uti.this.make();
        System.out.println("执行打包操作");
    }

    abstract void make();
}
