package cn.bravedawn.collection.list.commonuse;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExample6 {

    /**
     * 移除list中的元素
     */

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>(Arrays.asList("a", "", "b", "c", "", "e"));
        System.out.println(strings.removeIf(StringUtils::isBlank));
        System.out.println(strings);
    }
}
