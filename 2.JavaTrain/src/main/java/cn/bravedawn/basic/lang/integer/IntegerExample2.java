package cn.bravedawn.basic.lang.integer;

public class IntegerExample2 {

    /**
     * Java的包装类型都是不可变类，下面是拿Integer为例，虽然对变量a进行了两次赋值，但是两次赋值的对象是两个不同对象的指向
     * @param args
     */

    public static void main(String[] args) {

        Integer a = 1;
        System.out.println(a.hashCode());
        a = 2;
        System.out.println(a.hashCode());

    }

}
