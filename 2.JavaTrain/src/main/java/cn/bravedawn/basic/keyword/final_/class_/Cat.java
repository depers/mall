package cn.bravedawn.basic.keyword.final_.class_;

import cn.bravedawn.obj.accessright.protected2.C;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/1 13:24
 */
public final class Cat {


    /**
     * 将类用final关键字修饰
     */

    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Cat(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                '}';
    }

    public static void main(String[] args) {
        // 类声明中的 final 关键字并不意味着该类的对象是不可变的。我们可以自由改变类对象的字段：
        Cat cat =new Cat(10);
        cat.setWeight(12);
        System.out.println(cat);
    }
}
