package cn.bravedawn.generic.wildcards.lowerbounds.v2;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {

    /**
     * <? super GrandChildClass> 控制方法入参，对入参泛型类型进行限制
     */

    public static void main(String[] args) {

        // list of grand children
        List<GrandChildClass> grandChildren = new ArrayList<>();
        grandChildren.add(new GrandChildClass());
        addGrandChildren(grandChildren);

        // list of grand childs
        List<ChildClass> childs = new ArrayList<>();
        childs.add(new GrandChildClass());
        addGrandChildren(childs);

        // list of supers
        List<SuperClass> supers = new ArrayList<>();
        supers.add(new GrandChildClass());
        addGrandChildren(supers);

        // list of great grand child
        // 他的子类就不行
        List<GreatGrandChildClass> greatGrandChildClasses = new ArrayList<>();
        //greatGrandChildClasses.add(new GrandChildClass());
        //addGrandChildren(greatGrandChildClasses);
    }


    public static void addGrandChildren(List<? super GrandChildClass> grandChildren) {
        grandChildren.add(new GrandChildClass());
        System.out.println(grandChildren);
    }
}
