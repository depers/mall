package cn.bravedawn.generic.typeerasure;

public class TypeErasureExample3 {

    /**
     * Java泛型局限三：无法判断带泛型的类型
     * @param args
     */


    public static void main(String[] args) {
        Pair<String> p1 = new Pair<>("hello", "world");

        System.out.println(p1 instanceof Pair<String>); // true
        //System.out.println(p1 instanceof Pair<Integer>); // Compile error
    }
}
