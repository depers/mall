package cn.bravedawn.jvm.reference;

import java.lang.ref.WeakReference;

/**
 * @Author : depers
 * @Date : Created in 2026-02-02 10:06
 */
public class ReferenceExample {

    /**
     * refersTo()方法，如果该 Reference 当前仍然指向 obj，并且还没有被清除，返回 true；否则返回 false
     */


    public static void main(String[] args) throws InterruptedException {

        WeakReference<RoleDTO> weakReference = new WeakReference<>(new RoleDTO(1L, "小明"));

        if (!weakReference.refersTo(null)) {
            System.out.println("对象还存在");
        }

        System.gc();
        Thread.sleep(1000);

        if (weakReference.refersTo(null)) {
            System.out.println("对象已经不在了");
        }
    }
}
