package cn.bravedawn.collection.list.findlistelement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/16 13:17
 */
public class FindListElementExample {

    /**
     * 使用Java原生api查找列表中的一个元素
     * 1. contains
     * 2. indexOf: 使用此方法的主要优点是它可以告诉我们指定元素在给定列表中的位置
     * 3. Java Looping
     * 4. Looping with an Iterator
     */

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Jack"));
        customers.add(new Customer(2, "James"));
        customers.add(new Customer(3, "Kelly"));

        // contains()
        Customer james = new Customer(2, "James");
        System.out.println(customers.contains(james)); // true

        // indexOf()
        System.out.println(customers.indexOf(james) != -1); // true

        // Java Looping
        for (Customer customer : customers) {
            if (customer.getName().equals(james.getName())) {
                System.out.println(customer);
            }
        }

        // Looping with an Iterator
        System.out.println(findUsingIterator("james", customers));

    }

    public static Customer findUsingIterator(String name, List<Customer> customers) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }
}
