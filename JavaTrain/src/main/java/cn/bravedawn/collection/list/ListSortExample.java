package cn.bravedawn.collection.list;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListSortExample {


    /**
     * list排序
     */

    public static void main(String[] args) {
        Employee employee = new Employee("fengxiao", LocalDateTime.now());
        Employee employee2 = new Employee("xiaoming", LocalDateTime.now().minusDays(1));

        List<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee2);

        System.out.println(list);

        list.sort(Comparator.comparing(Employee::getDate));
        System.out.println(list);
        list.sort(Comparator.comparing(Employee::getDate).reversed());
        System.out.println(list);
    }
}
