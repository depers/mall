package cn.bravedawn.generic.border;

public class UnderBorderExample2 {

    public static void main(String[] args) {
        Pair<? super Integer> p = new Pair<>("12", 13);


        Integer x = (Integer) p.getFirst();
    }
}
