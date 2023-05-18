package cn.bravedawn.jvm.execution_engine;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/5/11 14:27
 */
public class FieldHasNoPolymorphic {

    /**
     * 方法输出：
     *      I am Son,  i have $0
     *      I am Son,  i have $4
     *      This gay has $2
     * 这段代码告诉我们，字段是没有多态性的
     */

    static class Father {
        public int money = 1;

        // 2.在调用Son的构造方法前，会先调用其父类的构造方法
        public Father() {
            money = 2;
            // 3.这个方法此时是一个虚方法调用，实际上调用的是Son的showMeTheMoney()方法，
            // 此时该方法访问的money字段其实是Son实例的，这会他还没有被赋初值，所以是0
            // 值得注意的是，这里父类的money字段已经被赋值为了2
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am Father, i have $" + money);
        }
    }

    static class Son extends Father {
        public int money = 3;

        public Son() {
            money = 4;
            // 4.第二次调用showMeTheMoney()方法，此时money字段已经被赋值为了4
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am Son,  i have $" + money);
        }
    }

    public static void main(String[] args) {
        // 1.电影Son类的构造方法
        Father gay = new Son();
        // 5.然后会打印下面这段代码，这里的money是父类Father的字段值2
        System.out.println("This gay has $" + gay.money);
    }
}
