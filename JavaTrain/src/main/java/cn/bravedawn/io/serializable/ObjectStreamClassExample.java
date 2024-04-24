package cn.bravedawn.io.serializable;

import java.io.ObjectStreamClass;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-15 17:19
 */
public class ObjectStreamClassExample {

    /**
     * ObjectStreamClass 充当类的序列化描述符。此类包含类的名称和 serialVersionUID。
     */


    public static void main(String[] args) {
        // 值得注意的是SmartPhone必须实现Serializable接口
        ObjectStreamClass osc = ObjectStreamClass.lookup(SmartPhone.class);
        System.out.println(osc.getField("price"));

        // 这个字段好奇怪，为什么拿不到？这个问题先留下
        ObjectStreamClass osc2 = ObjectStreamClass.lookup(String.class);
        System.out.println(osc2.getField("hash"));
    }
}
