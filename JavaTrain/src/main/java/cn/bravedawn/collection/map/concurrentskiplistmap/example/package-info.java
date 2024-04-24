/**
 * @program : JavaTrain
 * @author : depers
 * @date : Created in 2022/10/17 21:24
 */
package cn.bravedawn.collection.map.concurrentskiplistmap.example;

/**
 * ConcurrentSkipListMap 最显着的优点是可以以无锁方式对获取其数据的不可变快照。
 *
 * 通过这个例子，我们利用 ConcurrentSkipListMap 的高性能实现了一种非阻塞算法，
 * 即使同时多个线程正在更新映射，它也可以为我们提供不可变的数据快照。
 */