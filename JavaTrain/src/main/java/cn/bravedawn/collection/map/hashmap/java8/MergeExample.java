package cn.bravedawn.collection.map.hashmap.java8;

import cn.bravedawn.collection.map.hashmap.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/29 7:55
 */
public class MergeExample {

    public static void main(String[] args) {
        Map<String, Product> productsByName = new HashMap<>();
        Product eBike = new Product("E-Bike", "A bike with a battery");
        Product roadBike = new Product("Road bike", "A bike for competition");
        productsByName.put(eBike.getName(), eBike);
        productsByName.put(roadBike.getName(), roadBike);
        System.out.println(productsByName);

        Product eBike2 = new Product("E-Bike", "A bike with a battery");
        eBike2.getTags().add("sport");
        productsByName.merge("E-Bike", eBike2, Product::addTagsOfOtherProduct);
        System.out.println(productsByName);
    }
}
