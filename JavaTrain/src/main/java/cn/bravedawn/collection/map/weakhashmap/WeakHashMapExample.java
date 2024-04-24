package cn.bravedawn.collection.map.weakhashmap;

import java.util.WeakHashMap;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/10 11:57
 */
public class WeakHashMapExample {

    /**
     * WeakHashMap的工作原理实验，当把key的弱引用对象置为null后，调用gc后会自动触发垃圾回收，清空map
     */

    public static void main(String[] args) throws InterruptedException {
        // 创建一个WeakHashMap实例，它将存储BigImage对象。我们将BigImage对象作为值，imageName对象引用作为键。imageName将作为WeakReference类型存储在映射中。
        WeakHashMap<UniqueImageName, BigImage> map = new WeakHashMap<>();
        BigImage bigImage = new BigImage("image_id");
        UniqueImageName imageName = new UniqueImageName("name_of_big_image");

        map.put(imageName, bigImage);
        System.out.println(map.containsKey(imageName)); // true

        // 将imageName引用设置为空，因此不再有指向bigImage对象的引用。WeakHashMap的默认行为是回收在下一次GC中没有引用的条目，因此该条目将被下一次GC进程从内存中删除。
        imageName = null;

        // 调用System.gc()来强制JVM触发GC进程。在GC周期之后，我们的WeakHashMap将为空:
        System.gc();

        Thread.sleep(10000);
        System.out.println(map.isEmpty()); // true
    }



    static class BigImage {
        public final String imageId;

        BigImage(String imageId) {
            this.imageId = imageId;
        }
    }

   static class UniqueImageName {
        public final String imageName;

        UniqueImageName(String imageName) {
            this.imageName = imageName;
        }
    }
}
