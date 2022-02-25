package cn.bravedawn.generic.typeerasure;

public class TypeErasureExample2 {

    /**
     * Java泛型局限二：无法取得带泛型的Class
     */

    public static void main(String[] args) {
        Pair<String> p1 = new Pair<>("hello", "world");
        Pair<Integer> p2 = new Pair<>(123, 456);

        Class c1 = p1.getClass();
        Class c2 = p2.getClass();

        System.out.println(c1); // class cn.bravedawn.generic.typeerasure.Pair
        System.out.println(c2); // class cn.bravedawn.generic.typeerasure.Pair

        System.out.println(c1 == c2); // true
        System.out.println(c1 == Pair.class); // true
    }
}
