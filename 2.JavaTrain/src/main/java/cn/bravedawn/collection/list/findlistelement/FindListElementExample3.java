package cn.bravedawn.collection.list.findlistelement;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/17 15:47
 */
public class FindListElementExample3 {

    /**
     * 使用Guava查找列表中的一个元素
     * 如果list或是Predicate为空，这里会抛出NullPointException
     */

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Jack"));
        customers.add(new Customer(2, "James"));
        customers.add(new Customer(3, "Kelly"));


        // 如果匹配不到就会返回 null
        Customer james = Iterables.tryFind(customers, new Predicate<Customer>() {
            @Override
            public boolean apply(Customer input) {
                return "James".equals(input.getName());
            }
        }).orNull();

        // 如果匹配不到就会返回默认的值
        Customer james2 = Iterables.tryFind(customers, new Predicate<Customer>() {
            @Override
            public boolean apply(Customer input) {
                return "James".equals(input.getName());
            }
        }).or(customers.get(0));

        System.out.println(james);
        System.out.println(james2);
    }
}
