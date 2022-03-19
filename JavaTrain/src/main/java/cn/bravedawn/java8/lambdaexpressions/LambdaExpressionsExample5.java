package cn.bravedawn.java8.lambdaexpressions;

import java.util.*;

public class LambdaExpressionsExample5 {


    public static void main(String[] args) {
        List<Order> dateList = new ArrayList<>();

        Date d1 = new Date(2021, 10,21);
        Date d2 = new Date(2020, 10,21);
        Date d3 = new Date(2022, 10,21);
        dateList.add(new Order(2, d1));
        dateList.add(new Order(1, d2));
        dateList.add(new Order(3, d3));

        System.out.println(Arrays.toString(dateList.toArray()));
        List<Order> dateList1 = dateList.stream().sorted(Comparator.comparing(Order::getTime)).toList();
        System.out.println(Arrays.toString(dateList1.toArray()));
    }
}
