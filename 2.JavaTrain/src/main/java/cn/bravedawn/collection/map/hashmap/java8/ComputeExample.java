package cn.bravedawn.collection.map.hashmap.java8;

import cn.bravedawn.collection.map.hashmap.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/29 12:54
 */
public class ComputeExample {

    /**
     * 用指定的key去计算value
     * 值得注意的是 merge()和compute()非常相似
     * compute()接受两个参数：键和重新映射的BiFunction
     * merge()接受三个参数：键、添加到映射中的默认值和用于重新映射的BiFunction
     */

    public static void main(String[] args) {
        Map<String, Product> productsByName = new HashMap<>();
        Product eBike = new Product("E-Bike", "A bike with a battery");
        eBike.getTags().add("weekend");
        productsByName.put(eBike.getName(), eBike);
        System.out.println(productsByName); // {E-Bike=Product{name='E-Bike', description='A bike with a battery', tags=[weekend]}}

        Product eBike2 = new Product("E-Bike", "A bike with a battery");
        eBike2.getTags().add("sport");

        productsByName.compute("E-Bike", (k, v) -> {
            if (v != null) {
                return v.addTagsOfOtherProduct(eBike2);
            } else {
                return eBike2;
            }
        });
        System.out.println(productsByName); // {E-Bike=Product{name='E-Bike', description='A bike with a battery', tags=[weekend, sport]}}
    }
}
