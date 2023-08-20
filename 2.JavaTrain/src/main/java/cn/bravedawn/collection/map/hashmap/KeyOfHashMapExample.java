package cn.bravedawn.collection.map.hashmap;

import java.util.HashMap;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/9/28 21:10
 */
public class KeyOfHashMapExample {

    /**
     * 如果我们要使用一个类引用作为key，那么我们必须翻写这个类的equals()和hashcode()方法
     */


    public static void main(String[] args) {
        HashMap<Product, Integer> priceByProduct = new HashMap<>();
        Product eBike = new Product("E-Bike", "A bike with a battery");
        priceByProduct.put(eBike, 900);
    }
}
