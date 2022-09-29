package cn.bravedawn.collection.map.hashmap.java8;

import cn.bravedawn.collection.map.hashmap.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/29 12:51
 */
public class MergeExample2 {

    /**
     * 在Java8之前的实现
     */

    public static void main(String[] args) {
        Map<String, Product> productsByName = new HashMap<>();
        Product eBike = new Product("E-Bike", "A bike with a battery");
        eBike.getTags().add("weekend");
        productsByName.put(eBike.getName(), eBike);
        System.out.println(productsByName); // {E-Bike=Product{name='E-Bike', description='A bike with a battery', tags=[weekend]}}

        Product eBike2 = new Product("E-Bike", "A bike with a battery");
        eBike2.getTags().add("sport");

        if (productsByName.containsKey("E-Bike")) {
            productsByName.get("E-Bike").addTagsOfOtherProduct(eBike2);
        } else {
            productsByName.put("E-Bike", eBike2);
        }
        System.out.println(productsByName); // {E-Bike=Product{name='E-Bike', description='A bike with a battery', tags=[weekend, sport]}}
    }
}
