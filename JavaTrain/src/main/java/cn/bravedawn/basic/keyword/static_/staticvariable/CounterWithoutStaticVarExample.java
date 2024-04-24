package cn.bravedawn.basic.keyword.static_.staticvariable;

/**
 * @Description : 无静态变量的计数器程序
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-09-21 11:36
 */
public class CounterWithoutStaticVarExample {

    /**
     * 无静态变量的计数器程序
     *
     * 在此示例中，我们创建了一个名为 count 的实例变量，该变量在构造函数中递增。
     * 由于实例变量在创建对象时获取内存，因此每个对象都将具有实例变量的副本。如果递增，则不会影响其他对象。因此，每个对象在 count 变量中都具有值 1。
     */


    private int count = 0;


    public CounterWithoutStaticVarExample() {
        count++;
        System.out.println(count);
    }

    public static void main(String[] args) {
        CounterWithoutStaticVarExample c1 = new CounterWithoutStaticVarExample();
        CounterWithoutStaticVarExample c2 = new CounterWithoutStaticVarExample();
        CounterWithoutStaticVarExample c3 = new CounterWithoutStaticVarExample();


        /**
         * 输出：
         * 1
         * 1
         * 1
         */
    }
}
