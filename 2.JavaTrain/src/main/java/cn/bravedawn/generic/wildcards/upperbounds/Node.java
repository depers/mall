package cn.bravedawn.generic.wildcards.upperbounds;

import cn.bravedawn.generic.wildcards.Animal;
import cn.bravedawn.generic.wildcards.Cat;
import cn.bravedawn.generic.wildcards.Dog;

public class Node <T extends Animal> {  // public class Node<T extends Animal>


    /**
     * extends关键字的用途
     * 1.如果extends关键字用于类上，则他可以对成员变量的泛型类型进行校验
     * 2.成员变量可以访问父类的方法
     */


    private final T animal; // private final Animal animal;

    public static void main(String[] args) {
        Node<Animal> animalNode;
        Node<Dog> dogNode;
        Node<Cat> catNode;

        // 可以对成员变量的泛型类型进行校验
        // Node<String> stringNode; // 编译错误
    }


    public Node(T animal) { // public void Node(Animal animal)
        this.animal = animal;
    }

    // 成员变量可以访问泛型父类的方法。
    public void process() {
        animal.eat();
        animal.sleep();
    }
}
