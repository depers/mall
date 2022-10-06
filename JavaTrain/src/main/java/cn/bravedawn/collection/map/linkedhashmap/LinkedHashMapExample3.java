package cn.bravedawn.collection.map.linkedhashmap;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2022/10/6 17:02
 */
public class LinkedHashMapExample3 {

    /**
     * 在LinkedHashMap是不保证线程安全的，如果你有线程安全的要求，最好在创建时就按照下面的方式来做
     * 因为LinkedHashMap需要保证访问顺序，当accessOrder为true时，在调用get() API时就会导致结构的修改，除此之外，还有诸如放置和删除之类的操作。
     */

    public static void main(String[] args) {
        Map m = Collections.synchronizedMap(new LinkedHashMap());
    }
}
