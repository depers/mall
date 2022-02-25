package cn.bravedawn.generic.border;

public class TopBorderExample3 {


    /**
     * 下面注释的地方编译不通过的原因是Pair<Integer>并不是Pair<Number>的子类
     * @param args
     */

    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        //int n = add(p);
        //System.out.println(n);
    }



    static int add(Pair<Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        return first.intValue() + last.intValue();
    }

}
