package cn.bravedawn.obj.inherit.polymorphic.instance_initializer_block;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/1 17:22
 */
public class Bike {

    int speed;

    /**
     * 实例初始化代码块（Instance Initializer block）用于初始化实例数据成员。 每次创建类的对象时都会运行它。
     */
    {
        speed = 100;
    }


    Bike() {
        System.out.println("speed is " + speed);
    }

    public static void main(String[] args) {
        Bike bike = new Bike();
        Bike bike2 = new Bike();
    }
}
