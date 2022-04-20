package cn.bravedawn.spi.example;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Test {

    /**
     * ServiceLoader.load(Search.class)在加载某接口时，会去META-INF/services下找接口的全限定名文件，再根据里面的内容加载相应的实现类
     *
     *
     *
     * 源码分析
     * 从22行 iterator.hasNext()开始
     *
     * 1.java.util.ServiceLoader#iterator()#hasNext()
     * 2.java.util.ServiceLoader#newLookupIterator()#hasNext()
     * 3.java.util.ServiceLoader.LazyClassPathLookupIterator#hasNext()
     * 4.java.util.ServiceLoader.LazyClassPathLookupIterator#hasNextService()
     * 5.java.util.ServiceLoader.LazyClassPathLookupIterator#nextProviderClass()
     * 6.java.util.ServiceLoader.LazyClassPathLookupIterator#parse(java.net.URL)
     * 7.java.util.ServiceLoader.LazyClassPathLookupIterator#parseLine(java.net.URL, java.io.BufferedReader, int, java.util.Set)
     * ---2022年4月19日
     *
     * 4.java.util.ServiceLoader.LazyClassPathLookupIterator#hasNextService()
     *
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
