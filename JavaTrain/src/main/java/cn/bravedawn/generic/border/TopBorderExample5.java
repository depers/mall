package cn.bravedawn.generic.border;

public class TopBorderExample5 {


    /**
     * <? extends Number>通配符的一个重要限制：方法参数签名setFirst(? extends Number)无法传递任何Number的子类型给setFirst(? extends Number)
     *  下面两句被注释的代码，例如我传入的p是 Pair<Double>，他的setFirst方法肯定是不能够接受Integer类型的参数的，应该传入的是Double类型的
     */

    public static void main(String[] args) {
        Pair<Integer> p = new Pair<>(123, 456);
        int n = add(p);
        System.out.println(n);


        // 这里的例外是可以传入null
        p.setFirst(null);
        p.getFirst().intValue(); // 但是这里会报NullPointerException
    }

    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        //p.setFirst(new Integer(first.intValue() + 100));
        //p.setLast(new Integer(last.intValue() + 100));
        return p.getFirst().intValue() + p.getFirst().intValue();
    }
}
