package cn.bravedawn.collection.list.findlistelement;

import java.util.ArrayList;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/17 14:47
 */
public class FindListElementExample2 {

    /**
     * 通过Java8 Stream API查找元素
     */

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Jack"));
        customers.add(new Customer(2, "James"));
        customers.add(new Customer(3, "Kelly"));

        Customer james = customers.stream()
                .filter(customer -> "James".equals(customer.getName()))
                .findAny()
                .orElse(null);

        System.out.println(james);



    }


}
