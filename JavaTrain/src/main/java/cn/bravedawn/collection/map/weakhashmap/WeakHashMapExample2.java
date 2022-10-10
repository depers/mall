package cn.bravedawn.collection.map.weakhashmap;

import java.util.WeakHashMap;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/10/10 13:45
 */
public class WeakHashMapExample2 {


    /**
     * WeakHashMap的工作原理实验二，添加两个键值对到map中，gc只会清除一个被置为null的弱引用对象
     */

    public static void main(String[] args) throws InterruptedException {
        WeakHashMap<UniqueImageName, BigImage> map = new WeakHashMap<>();
        BigImage bigImageFirst = new BigImage("foo");
        UniqueImageName imageNameFirst = new UniqueImageName("name_of_big_image");

        BigImage bigImageSecond = new BigImage("foo_2");
        UniqueImageName imageNameSecond = new UniqueImageName("name_of_big_image_2");

        map.put(imageNameFirst, bigImageFirst);
        map.put(imageNameSecond, bigImageSecond);

        imageNameFirst = null;
        System.gc();

        Thread.sleep(10000);

        System.out.println(map.size()); // 1
        System.out.println(map.containsKey(imageNameSecond)); // true
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
