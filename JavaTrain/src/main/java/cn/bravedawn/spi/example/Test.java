package cn.bravedawn.spi.example;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Test {

    /**
     * ServiceLoader.load(Search.class)在加载某接口时，会去META-INF/services下找接口的全限定名文件，再根据里面的内容加载相应的实现类
     */


    public static void main(String[] args) {

        ServiceLoader<Search> s = ServiceLoader.load(Search.class);
        Iterator<Search> iterator = s.iterator();
        while (iterator.hasNext()) {
            Search search =  iterator.next();
            search.searchDoc("hello world");
        }
    }
}
