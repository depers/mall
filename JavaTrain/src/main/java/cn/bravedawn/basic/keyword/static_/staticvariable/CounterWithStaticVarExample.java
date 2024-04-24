package cn.bravedawn.basic.keyword.static_.staticvariable;

/**
 * @Description : 静态变量计数器程序
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-09-21 11:37
 */
public class CounterWithStaticVarExample {

    /**
     * 静态变量计数器程序
     *
     * 静态变量只会获得一次内存，如果任何对象更改了静态变量的值，它将保留其值。
     */

    private static int count = 0;


    public CounterWithStaticVarExample() {
        count++;
        System.out.println(count);
    }


    public static void main(String[] args) {
        CounterWithStaticVarExample c1 = new CounterWithStaticVarExample();
        CounterWithStaticVarExample c2 = new CounterWithStaticVarExample();
        CounterWithStaticVarExample c3 = new CounterWithStaticVarExample();

        /**
         * 输出：
         * 1
         * 2
         * 3
         */
    }
}
