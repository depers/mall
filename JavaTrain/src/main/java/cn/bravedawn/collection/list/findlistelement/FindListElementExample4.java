package cn.bravedawn.collection.list.findlistelement;

import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.Predicate;

import java.util.ArrayList;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/17 15:57
 */
public class FindListElementExample4 {

    /**
     * 使用Apache Commons Collection实现查找一个元素
     * 与Guava不同的是：
     * 1.如果我们传递的一个null的list，它将会返回null
     * 2.如果匹配不到，无法配置默认值返回
     */

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Jack"));
        customers.add(new Customer(2, "James"));
        customers.add(new Customer(3, "Kelly"));

        Customer james = IterableUtils.find(customers, new Predicate<Customer>() {
            @Override
            public boolean evaluate(Customer customer) {
                return "James".equals(customer.getName());
            }
        });
        System.out.println(james); // Customer{id=2, name='James'}
    }
}
