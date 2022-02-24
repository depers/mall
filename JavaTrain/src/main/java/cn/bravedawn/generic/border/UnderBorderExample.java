package cn.bravedawn.generic.border;

public class UnderBorderExample {

    static void setSame(Pair<Integer> p, Integer n) {
        p.setFirst(n);
        p.setLast(n);
    }

    public static void main(String[] args) {
        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        //setSame(p1, 100);
        setSame(p2, 200);


        System.out.println(p1.getFirst() + ", " + p1.getLast());
        System.out.println(p2.getFirst() + ", " + p2.getLast());
    }

}
