package cn.bravedawn.jvm.reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @Author : fengx9
 * @Project : jvm-demo
 * @Date : Created in 2024-03-14 16:55
 *
 *
 * WeakReference第二种使用方式：WeakReference(T referent, ReferenceQueue<? super T> q)
 * 这个构造方法多了个参数，是个引用队列类型；当发生GC后，被弱引用指向的对象被回收，同时这些弱引用将会被添加的这个引用队列当中。
 */
public class WeakReferenceExample2 {


    public static void main(String[] args) throws InterruptedException {
        // 引用队列
        ReferenceQueue<RoleDTO> referenceQueue = new ReferenceQueue<>();
        WeakReference<RoleDTO> weakReference = new WeakReference<>(new RoleDTO(1l, "CFO"), referenceQueue);

        System.out.println("执行GC之前");
        System.out.println("weakReference是:" + weakReference);
        Reference<? extends RoleDTO> reference;
        // 引用队列时空的
        while ((reference = referenceQueue.poll()) != null) {
            System.out.println("referenceQueue中：" + reference);
        }

        System.gc();
        Thread.sleep(1000);

        System.out.println("执行GC之后");
        if (weakReference.get() == null) {
            System.out.println("弱引用指向的RoleDTO对象 已经被回收");
        }

        Reference<? extends RoleDTO> reference2;
        while ((reference2 = referenceQueue.poll()) != null) {
            // 如果使用继承的方式就可以包含其他信息了
            System.out.println("referenceQueue中：" + reference2);
        }
    }
}
