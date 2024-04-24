package cn.bravedawn.generic.typeerasure.newt;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/2/25 21:20
 */
public class Test {

    /**
     * 通过工厂模式+泛型方法来创建泛型实例对象
     * 上面代码中我们创建了一个IntegerFactory工厂，用来创建Integer实例，以后代码有变动的话，我们可以添加新的工厂类型即可。
     */

    public static void main(String[] args) {
        Creator<Integer> creator = new Creator<>();
        System.out.println(creator.newInstance(new IntegerFactory()));
    }
}
