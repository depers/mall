package cn.bravedawn.spi.example;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Test {


    public static void main(String[] args) {

        ServiceLoader<Search> s = ServiceLoader.load(Search.class);
        Iterator<Search> iterator = s.iterator();
        while (iterator.hasNext()) {
            Search search =  iterator.next();
            search.searchDoc("hello world");
        }
    }
}
