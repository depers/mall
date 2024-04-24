package cn.bravedawn.collection.map.hashmap.java8;

import cn.bravedawn.collection.map.hashmap.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/29 9:06
 */
public class MergeExample {

    /**
     * 这个方法的作用就是 针对于这个key的value进行合并操作，如果这个映射不存在的话就会添加一个新值
     */

    public static void main(String[] args) {
        Map<String, Product> productsByName = new HashMap<>();
        Product eBike = new Product("E-Bike", "A bike with a battery");
        eBike.getTags().add("weekend");
        productsByName.put(eBike.getName(), eBike);
        System.out.println(productsByName); // {E-Bike=Product{name='E-Bike', description='A bike with a battery', tags=[weekend]}}

        Product eBike2 = new Product("E-Bike", "A bike with a battery");
        eBike2.getTags().add("sport");
        productsByName.merge("E-Bike", eBike2, Product::addTagsOfOtherProduct);
        System.out.println(productsByName); // {E-Bike=Product{name='E-Bike', description='A bike with a battery', tags=[weekend, sport]}}
    }
}
