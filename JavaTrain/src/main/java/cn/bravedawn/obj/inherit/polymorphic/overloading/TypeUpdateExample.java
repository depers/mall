package cn.bravedawn.obj.inherit.polymorphic.overloading;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/11/3 12:58
 */
public class TypeUpdateExample {

    /**
     * 如果重载的参数类型与方法实际传入的类型不一致怎么办？换句话说实参的数据类型与形参的数据类型不一样，Java如何去选择合适的重载方法？
     *
     * Java将会进行数据转换，将实参的数据类型转换到更高一级的数据类型，从而去匹配合适的重载方法，如果没有匹配到就会报错
     */

    public void show(int x) {
        System.out.println("In int " + x);
    }
    public void show(String s) {
        System.out.println("In String " + s);
    }
    public void show(byte b) {
        System.out.println("In byte " + b);
    }

    //public void show(Object o) {
    //    System.out.println(o);
    //}

    public static void main(String[] args) {
        byte a = 25;
        TypeUpdateExample obj = new TypeUpdateExample();

        // it will go to
        // byte argument
        obj.show(a);

        // String
        obj.show("hello");

        // Int
        obj.show(250);

        // Since char is
        // not available, so the datatype
        // higher than char in terms of
        // range is int.
        obj.show('A');

        // String
        obj.show("A");

        // since float datatype
        // is not available and so it's higher
        // datatype, so at this step their
        // will be an error.
        //obj.show(7.5);
    }
}
