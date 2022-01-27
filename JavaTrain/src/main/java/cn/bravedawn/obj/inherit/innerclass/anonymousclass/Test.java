package cn.bravedawn.obj.inherit.innerclass.anonymousclass;

import java.util.HashMap;

public class Test {


    public static void main(String[] args) {
        Outer outer = new Outer("Nested");
        outer.asyncHello();


        // 匿名类也可以完全继承普通类
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>() {};
        HashMap<String, String> map3 = new HashMap<>() {
            {
                put("A", "1");
                put("B", "2");
            }
        };

        System.out.println(map3.get("A"));
    }
}
