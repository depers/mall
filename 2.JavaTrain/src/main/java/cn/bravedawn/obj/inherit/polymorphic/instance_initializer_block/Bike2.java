package cn.bravedawn.obj.inherit.polymorphic.instance_initializer_block;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/1 17:30
 */
public class Bike2 {

    int speed;

    Bike2() {
        System.out.println("constructor is invoked");
    }

    {
        System.out.println("instance initializer block invoked");
    }

    public static void main(String args[]) {
        Bike2 b1 = new Bike2();
        Bike2 b2 = new Bike2();
    }
}
