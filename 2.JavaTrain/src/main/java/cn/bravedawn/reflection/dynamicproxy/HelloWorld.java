package cn.bravedawn.reflection.dynamicproxy;

public class HelloWorld implements Hello{

    @Override
    public void morning(String name) {
        System.out.println("Good morning, " + name);
    }
}
