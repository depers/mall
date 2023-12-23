package cn.bravedawn.io.obj;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.*;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 17:14
 */
public class ObjectOutputStreamExample {

    /**
     * 序列化对象，序列化就是将一个对象转换成字节序列，方便存储和传输。
     *  序列化: ObjectOutputStream.writeObject()
     *  反序列化: ObjectInputStream.readObject()
     * 不会对静态变量进行序列化，因为序列化只是保存对象的状态，静态变量属于类的状态。
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SmartPhone smartPhone = new SmartPhone("小米", "2299");
        String objFilePath = ResourceHelper.getAbsoluteFilePath("doc/obj.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(objFilePath));
        outputStream.writeObject(smartPhone);
        outputStream.close();


        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(objFilePath));
        SmartPhone readObj = (SmartPhone) inputStream.readObject();
        inputStream.close();
        System.out.println(readObj);


    }
}
