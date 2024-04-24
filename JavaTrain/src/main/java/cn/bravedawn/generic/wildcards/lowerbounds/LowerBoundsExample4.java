package cn.bravedawn.generic.wildcards.lowerbounds;

import cn.bravedawn.generic.wildcards.*;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundsExample4 {

    /**
     * 1.泛型的下界描述符是支持添加元素的，因为他没有类型转换失败的风险
     * 2.泛型的下界描述符修饰的集合只能添加指定类型或是指定类型的子类，添加其他类型是会编译失败的，切记不要将接收泛型类和添加泛型类弄混了
     * 3.大家就会发现，协变和逆变正好相反，上界发生协变只读不写，下界发生逆变只写不读。所以两者的使用场景也就出来了，正如copyHappyDog()方法
     *      1）如果我对泛型只读不写时，使用协变，下界描述符。
     *      2）如果我对泛型只写不读时，使用逆变，上界描述符。
     *      3）如果我又想写又想读，那你不需要使用逆变和协变，你需要使用准确的泛型类型。
     *      4）泛型的协变和逆变一般只使用在方法上，声明形参来接收调用者传递的实参，之前的代码中使用协变和逆变修饰变量和类是为了方便演示。
     */


     /**
     * 我们现在有一个场景，将src列表的元素复制到dest列表中
     * @param dest 目标列表
     * @param src 源列表
     */
    public static void copyHappyDog(List<? super Dog> dest, List<? extends Dog> src) {
        for (Dog dog : src) {
            dest.add(dog);
        }
    }

    public static void func(List<? super Dog> list) {
        list.add(new Dog());
        list.add(new HsqDog());
        list.add(new SmyDog());

        //list.add(new Animal()); // 添加其他元素就会编译错误
        //list.add(new Cat());  // 编译错误

        // 使用下界描述符声明的对象，只能使用Object类型获取对象
        Object object = list.get(0);

        //Animal animal = list.get(0); // 编译错误
        //Dog dog = list.get(0); // 编译错误
    }


    public static void main(String[] args) {
        func(new ArrayList<Dog>());
        func(new ArrayList<Animal>());
        func(new ArrayList<Object>());

        //func(new ArrayList<SmyDog>()); // 传入子类的泛型类就会编译错误
    }
}
