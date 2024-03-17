package cn.bravedawn.jvm.reference;

import java.lang.ref.WeakReference;

/**
 * @Author : fengx9
 * @Project : jvm-demo
 * @Date : Created in 2024-03-14 16:49
 *
 *
 * WeakReference第一种使用方式：WeakReference(T referent)
 */
public class WeakReferenceExample {


    public static void main(String[] args) throws InterruptedException {
        RoleDTO roleDTO = new RoleDTO(1l, "CEO");

        WeakReference<RoleDTO> weakReference = new WeakReference<>(new RoleDTO(1l, "CEO"));

        System.gc();
        Thread.sleep(1000);

        if (roleDTO == null) {
            System.out.println("强引用被回收了");
        }

        if (weakReference.get() == null) {
            System.out.println("弱引用指向的对象被回收了");
        }
    }
}
