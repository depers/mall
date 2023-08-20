package cn.bravedawn.generic.variant;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/8/14 21:58
 */
public class VariantExample2 {


    public static void main(String[] args) {

        // 数组是支持协变的
        Animal[] animals = new Dog[10];
        animals[0] = new Animal();
        animals[1] = new Dog();

        process(animals);

        testException();
    }


    /**
     * 为什么Java的数组是支持泛型的：
     * 一是Java数组是1.0版本提出来的，那个时候还没有泛型。
     * 而是Java设计者希望能够对数组进行通用的处理，如果数组不支持协变的话，很多方法就得为每一种类型编写逻辑了，如下所示
     * @param array
     */
    public static void process(Object[] array) {

    }

    public static void process(Animal[] animals) {

    }

    public static void process(Dog[] dogs) {

    }

    public static void process(Cat[] cats) {

    }


    /**
     * 数组的协变存在安全问题，如果将其他类型的对象赋值到数组中会报错
     */
    public static void testException() {
        Animal[] animals = new Dog[10];
        animals[0] = new Dog();
        animals[1] = new Cat(); // ArrayStoreException
    }
}
