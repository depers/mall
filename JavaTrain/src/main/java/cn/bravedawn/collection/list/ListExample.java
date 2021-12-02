package cn.bravedawn.collection.list;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListExample {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println(Arrays.toString(new Set[]{set}));

        List<Integer> list = Lists.newArrayList(set);

        System.out.println(list.toString());
    }
}
