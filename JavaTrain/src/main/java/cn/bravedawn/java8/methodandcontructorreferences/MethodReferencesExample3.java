package cn.bravedawn.java8.methodandcontructorreferences;

public class MethodReferencesExample3 {


    /**
     * 我们通过 Person::new 创建对 Person 构造函数的引用。 Java 编译器通过匹配 PersonFactory.create 的签名自动选择正确的构造函数
     */

    public static void main(String[] args) {
        PersonFactory personPersonFactory = Person::new;
        Person person = personPersonFactory.create("Peter", "Parker");
    }

}
